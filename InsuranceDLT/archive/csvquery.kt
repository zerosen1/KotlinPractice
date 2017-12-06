import java.io.FileNotFoundException
import java.io.FileReader
import java.sql.Connection
import java.sql.PreparedStatement
import java.util.Date

import org.apache.commons.lang.StringUtils

import au.com.bytecode.opencsv.CSVReader
import com.mysql.jdbc.StringUtils

import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close

/**
 *
 * @author viralpatel.net
 */
class CSVLoader
/**
 * Public constructor to build CSVLoader object with
 * Connection details. The connection is closed on success
 * or failure.
 * @param connection
 */
(private val connection: Connection?) {
    var seprator: Char = ' '

    init {
        //Set default separator
        this.seprator = ','
    }

    /**
     * Parse CSV file using OpenCSV library and load in
     * given database table.
     * @param csvFile Input CSV file
     * @param tableName Database table name to import data
     * @param truncateBeforeLoad Truncate the table before inserting
     * new records.
     * @throws Exception
     */
    @Throws(Exception::class)
    fun loadCSV(csvFile: String, tableName: String,
                truncateBeforeLoad: Boolean) {

        var csvReader: CSVReader? = null
        if (null == this.connection) {
            throw Exception("Not a valid connection.")
        }
        try {

            csvReader = CSVReader(FileReader(csvFile), this.seprator)

        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception("Error occured while executing file. " + e.message)
        }

        val headerRow = csvReader!!.readNext() ?: throw FileNotFoundException(
                "No columns defined in given CSV file." + "Please check the CSV file format.")

        var questionmarks = StringUtils.repeat("?,", headerRow.size)
        questionmarks = questionmarks.subSequence(0, questionmarks
                .length - 1)

        var query = SQL_INSERT.replaceFirst(TABLE_REGEX.toRegex(), tableName)
        query = query
                .replaceFirst(KEYS_REGEX.toRegex(), StringUtils.join(headerRow, ","))
        query = query.replaceFirst(VALUES_REGEX.toRegex(), questionmarks)

        println("Query: " + query)

        var nextLine: Array<String>?
        var con: Connection? = null
        var ps: PreparedStatement? = null
        try {
            con = this.connection
            con.autoCommit = false
            ps = con.prepareStatement(query)

            if (truncateBeforeLoad) {
                //delete data from table before loading csv
                con.createStatement().execute("DELETE FROM " + tableName)
            }

            val batchSize = 1000
            var count = 0
            var date: Date? = null
            while ((nextLine = csvReader!!.readNext()) != null) {

                if (null != nextLine) {
                    var index = 1
                    for (string in nextLine) {
                        date = DateUtil.convertToDate(string)
                        if (null != date) {
                            ps!!.setDate(index++, java.sql.Date(date!!
                                    .time))
                        } else {
                            ps!!.setString(index++, string)
                        }
                    }
                    ps!!.addBatch()
                }
                if (++count % batchSize == 0) {
                    ps!!.executeBatch()
                }
            }
            ps!!.executeBatch() // insert remaining records
            con.commit()
        } catch (e: Exception) {
            con!!.rollback()
            e.printStackTrace()
            throw Exception(
                    "Error occured while loading data from file to database." + e.message)
        } finally {
            if (null != ps)
                ps.close()
            if (null != con)
                con.close()

            csvReader!!.close()
        }
    }

    companion object {

        private val SQL_INSERT = "INSERT INTO \${table}(\${keys}) VALUES(\${values})"
        private val TABLE_REGEX = "\\$\\{table\\}"
        private val KEYS_REGEX = "\\$\\{keys\\}"
        private val VALUES_REGEX = "\\$\\{values\\}"
    }

}
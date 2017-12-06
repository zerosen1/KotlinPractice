import java.io.File
import java.io.FileNotFoundException
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

fun all(csvFile:String) {
    var stmt: Statement? = null
    var resultset: ResultSet? = null
    var HeaderRow = File(csvFile).readLines()?: throw FileNotFoundException(
            "No columns defined in given CSV file." + "Please check the CSV file format.")
    try {
        stmt = conn!!.prepareStatement(query)
















    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    } catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    } finally {
        // release resources
        if (resultset != null) {
            try {
                resultset.close()
            } catch (sqlEx: SQLException) {
            }

            resultset = null
        }

        if (stmt != null) {
            try {
                stmt.close()
            } catch (sqlEx: SQLException) {
            }

            stmt = null
        }

        if (conn != null) {
            try {
                conn!!.close()
            } catch (sqlEx: SQLException) {
            }
            conn = null
        }
    }
}
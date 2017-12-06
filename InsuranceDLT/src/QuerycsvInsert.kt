import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import DatabaseConnection.conn


fun QuerycsvInsert() {
    var stmt: Statement? = null
    var resultset: ResultSet? = null
    var Table: String = "insurancedb"
    try {
        stmt = conn!!.createStatement()
        val sql = "INSERT INTO "+ Table+ " VALUES"+ readCsvFileKotlin("C:\\Users\\kenji.a.sato\\Desktop\\insurancedb.csv")
        stmt.executeUpdate(sql)
        println("insertsucess")
    } catch (ex: SQLException) {
        ex.printStackTrace()
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}
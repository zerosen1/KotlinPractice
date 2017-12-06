import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import DatabaseConnection.conn

fun executeMySQLQuery() {
    var stmt: Statement? = null
    var resultset: ResultSet? = null

    try {
        stmt = conn!!.createStatement()
        resultset = stmt!!.executeQuery("SHOW DATABASES;")

        if (stmt.execute("SHOW DATABASES;")) {
            resultset = stmt.resultSet
        }

        while (resultset!!.next()) {
            println(resultset.getString("Database"))
        }
    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    }
}
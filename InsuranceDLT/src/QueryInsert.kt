import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import DatabaseConnection.conn
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close



fun QueryInsert() {
    var stmt: Statement? = null
    var resultset: ResultSet? = null

    try {
        stmt = conn!!.createStatement()
        val sql = "INSERT INTO Employees " + "VALUES (100, 30, 'Zaraa', 'Alia')"
        stmt.executeUpdate(sql)
        println("insertsucess")
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
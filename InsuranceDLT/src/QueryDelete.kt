import DatabaseConnection.conn
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

fun QueryDelete() {
    var stmt: Statement? = null
    var resultset: ResultSet? = null
    var Table: String = "insurancedb"
    try {
        stmt = conn!!.createStatement()


        var sql = "DELETE FROM Employees " + "WHERE(age=20)"
        stmt.executeUpdate(sql)
        println("deletesucess")

        sql = "SELECT id, first, last, age FROM Employees"
        resultset = stmt!!.executeQuery(sql)


        if (stmt.execute(sql)) {
            resultset = stmt.resultSet
        }
        while (resultset!!.next()) {
            //Retrieve by column name
            val id = resultset.getInt("id")
            val age = resultset.getInt("age")
            val first = resultset.getString("first")
            val last = resultset.getString("last")
            //Display values
            System.out.print("ID: " + id)
            System.out.print(", Age: " + age)
            System.out.print(", First: " + first)
            System.out.println(", Last: " + last)
        }

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
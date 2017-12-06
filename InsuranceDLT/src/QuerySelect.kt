import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import DatabaseConnection.conn

fun QuerySelect() {
    var stmt: Statement? = null
    var resultset: ResultSet? = null
    var Table: String = "insurancedb"
    try {
        var sql = "SELECT * FROM $Table"
        resultset = stmt!!.executeQuery(sql)

        if (stmt.execute(sql)) {
            resultset = stmt.resultSet
        }

        while (resultset!!.next()) {
            println(resultset.toString())
            //Retrieve by column name
            val id = resultset.getString("NRIC")
            val age = resultset.getInt("FirstName")
            val first = resultset.getString("MiddleName")
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
    } }
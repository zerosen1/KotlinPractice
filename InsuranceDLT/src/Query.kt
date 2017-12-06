import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import DatabaseConnection.conn
import DatabaseConnection.stmt

object Query{

    var Table: String = "insurancedb"


    fun CSVInsert() {
        try {
            val sql = "INSERT INTO "+ Table+ " VALUES"+ readCsvFileKotlin("C:\\Users\\kenji.a.sato\\Desktop\\insurancedb.csv")
            stmt?.executeUpdate(sql)
            println("insertsucess")
        } catch (ex: SQLException) {
            ex.printStackTrace()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }


    fun resultset() {
        try{
        var resultset: ResultSet? = null
        var sql = "SELECT * FROM $Table"
        resultset = stmt!!.executeQuery(sql)
        if (stmt!!.execute(sql)) {
            resultset = stmt!!.resultSet
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
    }}
    fun query(){
        try {

        } catch (ex: SQLException) {
            ex.printStackTrace()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun Insert2(){
        val sql = "INSERT INTO "+ Table+ " VALUES"+ readCsvFileKotlin("C:\\Users\\kenji.a.sato\\Desktop\\insurancedb.csv")
        stmt?.executeUpdate(sql)
        println("insertsucess")
    }




}






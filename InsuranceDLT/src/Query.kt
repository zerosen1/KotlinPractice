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
    fun Insert(details:String) {
        try {
            val sql = "INSERT INTO "+ Table+ " VALUES"+ details
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
                //Retrieve by column name
                val NRIC = resultset.getString("NRIC")
                val FirstName = resultset.getString("FirstName")
                val MiddleName = resultset.getString("MiddleName")
                val LastName = resultset.getString("LastName")
                val DateOfBirth = resultset.getString("DateOfBirth")
                val PolicyID = resultset.getString("PolicyID")
                val PolicyAmount = resultset.getString("PolicyAmount")
                val PolicyExpiry = resultset.getString("PolicyExpiry")
                val eLOGActive = resultset.getInt("eLOGActive")

                //Display values
                System.out.print("NRIC: " + NRIC)
                System.out.print(", FirstName: " + FirstName)
                System.out.print(", MiddleName: " + MiddleName)
                System.out.print(", LastName: " + LastName)
                System.out.print(", DateOfBirth: " + DateOfBirth)
                System.out.print(", PolicyID: " + PolicyID)
                System.out.print(", PolicyAmount: " + PolicyAmount)
                System.out.print(", PolicyExpiry: " + PolicyExpiry)
                System.out.println(", eLOGActive: " + eLOGActive)
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






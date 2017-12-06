import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import DatabaseConnection.conn
import DatabaseConnection.stmt
import com.javasampleapproach.requestmapping.controller.WebController
import com.javasampleapproach.requestmapping.model.Customer


object Query{
    var storage1 = mutableMapOf<Long, Customer>()
    var Table: String = "insurancedb"
//    fun CSVInsert() {
//        try {
//            val sql = "INSERT INTO "+ Table+ " VALUES"+ readCsvFileKotlin("C:\\Users\\kenji.a.sato\\Desktop\\insurancedb.csv")
//            stmt?.executeUpdate(sql)
//            println("insertsucess")
//        } catch (ex: SQLException) {
//            ex.printStackTrace()
//        } catch (ex: Exception) {
//            ex.printStackTrace()
//        }
//    }
    fun Insert(customer: Customer): Customer {
        try {
            val sql = "INSERT INTO "+ Table+ " VALUES"+ customer.toString()
            stmt?.executeUpdate(sql)
            return customer
        } catch (ex: SQLException) {
            ex.printStackTrace()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    return customer
    }

    fun resultset():MutableMap<Long, Customer> {
        try {
            var c = WebController()
            var resultset: ResultSet? = null
            var sql = "SELECT * FROM $Table"
            resultset = stmt!!.executeQuery(sql)
            if (stmt!!.execute(sql)) {
                resultset = stmt!!.resultSet
            }
            var i: Long = 1
            while (resultset!!.next()) {
                //Retrieve by column name
                val NRIC = resultset.getString("NRIC")
                val FirstName = resultset.getString("FirstName")
                val MiddleName = resultset.getString("MiddleName")
                val LastName = resultset.getString("LastName")
                val DateOfBirth = resultset.getString("DateOfBirth")
                val PolicyID = resultset.getString("PolicyID")
                val PolicyAmount = resultset.getFloat("PolicyAmount")
                val PolicyExpiry = resultset.getString("PolicyExpiry")
                val eLOGActive = resultset.getInt("eLOGActive")
                storage1.put(i, Customer(i, NRIC, FirstName, MiddleName, LastName, DateOfBirth, PolicyID, PolicyAmount, PolicyExpiry, eLOGActive))
                ++i

            }
        } catch (ex: SQLException) {
            ex.printStackTrace()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return storage1
        }

    fun Put(customer:Customer):Customer {
        try {
        val sql = "REPLACE INTO "+ Table+ " VALUES"+ customer
            println(sql)
        stmt?.executeUpdate(sql)
        return customer
    } catch (ex: SQLException) {
        ex.printStackTrace()
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
        return customer
}
    fun Delete(customer: Customer): Customer {
        try {
            val sql = "DELETE FROM "+ Table+ " WHERE NRIC = "+ customer.toString()
            println(sql)
            stmt?.executeUpdate(sql)
            return customer
        } catch (ex: SQLException) {
            ex.printStackTrace()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return customer
    }




//        fun query() {
//            try {
//
//            } catch (ex: SQLException) {
//                ex.printStackTrace()
//            } catch (ex: Exception) {
//                ex.printStackTrace()
//            }
//        }

//    fun Insert2(){
//        val sql = "INSERT INTO "+ Table+ " VALUES"+ readCsvFileKotlin("C:\\Users\\kenji.a.sato\\Desktop\\insurancedb.csv")
//        stmt?.executeUpdate(sql)
//        println("insertsucess")
//    }
//
    }









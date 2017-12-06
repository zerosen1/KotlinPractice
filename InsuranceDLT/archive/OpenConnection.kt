import DatabaseConnection.getCredentials
import DatabaseConnection.getDB
import DatabaseConnection.getIP
import DatabaseConnection.getPort
import DatabaseConnection.setIP
import java.sql.*
import java.util.Properties

/**
 * This method makes a connection to MySQL Server
 * In this example, MySQL Server is running in the local host (so 127.0.0.1)
 * at the standard port 3306
 */

fun OpenConnection() {
    println("OpeningConnection")
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance()
        conn = DriverManager.getConnection("jdbc:mysql://" + getIP()+ ":" + getPort()+ "/"+ getDB(), getCredentials())
//                        +"?rewriteBatchedStatements=true" //this statement auto change individual insert into a multi (bundled) but i didnt need to
    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    } catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    }
}
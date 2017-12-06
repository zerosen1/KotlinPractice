import java.sql.*
import java.util.Properties

/**
 * This method makes a connection to MySQL Server
 * In this example, MySQL Server is running in the local host (so 127.0.0.1)
 * at the standard port 3306
 */

fun getConnection() {
    val connectionProps = Properties()
    connectionProps.put("user", "root")
    connectionProps.put("password", "123456")
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance()
        conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "127.0.0.1" +
                        ":" + "3306" + "/" +
                        "EMP",
                connectionProps)
        println("jdbc:" + "mysql" + "://" +"127.0.0.1" +":" + "3306" + "/" +"EMP")
        println(connectionProps)

    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    } catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    }
}
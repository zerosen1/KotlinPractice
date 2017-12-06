import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement
import java.util.*
import java.util.regex.Pattern



object DatabaseConnection {//note to self:May use String? instead of String
var conn: Connection? = null
    var stmt: Statement? = null

private var IPaddress:String = ""
fun setIP(newIP:String){
    val IP_ADDRESS = Pattern.compile(
            "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4]"
                    + "[0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]"
                    + "[0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}"
                    + "|[1-9][0-9]|[0-9]))")
    val matcher = IP_ADDRESS.matcher(newIP)
    try{
        if (matcher.matches()) {IPaddress=newIP}else {throw IllegalArgumentException("IPAddress Invalid: Please Check")}
    }catch(ex: Exception){ex.printStackTrace()}}
fun getIP():String{return IPaddress}


private var PortNumber:String = ""
fun setPort(newPort:String){
        PortNumber=newPort
    }
fun getPort():String{return PortNumber}


private var DataBase:String=""
fun setDB(newDB:String){
        DataBase=newDB
    }
fun getDB():String{return DataBase}


private var Credentials = Properties()
fun SetCredentials(username:String,password:String){
    Credentials.put("user", username)
    Credentials.put("password", password)
    }
fun getCredentials():Properties{return Credentials}


fun OpenConnection() {
    println("::OpeningConnection::")
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance()
            conn = DriverManager.getConnection("jdbc:mysql://" + getIP()+ ":" + getPort()+ "/"+ getDB(), getCredentials())
//                        +"?rewriteBatchedStatements=true" //this statement auto change individual insert into a multi (bundled) but i didnt need to
            stmt = conn!!.createStatement()
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
    }
fun CloseConnection() {
    // release resources

    try {
        stmt?.close()
    } catch (sqlEx: SQLException) {
    }
    stmt = null
    try {
        conn?.close()
    } catch (sqlEx: SQLException) {
    }
    conn = null
    println("ClosingConnection")
}}

//var username = "root" // provide the username
//var password = "123456" // provide the corresponding password
//    val IP_ADDRESS = Pattern.compile(
//            "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4]"
//                    + "[0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]"
//                    + "[0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}"
//                    + "|[1-9][0-9]|[0-9]))")
//    val matcher = IP_ADDRESS.matcher(ip)
//    if (matcher.matches()) {// ip is correct}
//validate //regular expression ip validation kotlin
//var username = "root" // provide the username
//var password = "123456" // provide the corresponding password
//var IPaddress = "127.0.0.1"
//var PortNumber = "3300"
//val SetCredentials = Properties()
//SetCredentials.put("user", username)
//SetCredentials.put("password", password)
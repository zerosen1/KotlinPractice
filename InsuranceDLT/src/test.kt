import java.sql.*


object test {
//
    @JvmStatic
    fun main(args: Array<String>) {
    DatabaseConnection.setIP("127.0.0.1")
    DatabaseConnection.setPort("3306")
    DatabaseConnection.setDB("EMP")
    DatabaseConnection.SetCredentials("root" ,"123456")


    DatabaseConnection.OpenConnection()
        var x = "('S9328106E','Kenji','jon','Sato','1993-08-05','fe8218u','18.2','2018-05-31','1')"
            Query.Insert(x)
//        Query.CSVInsert()
            Query.resultset()
//        QuerySelect()
    DatabaseConnection.CloseConnection()

//    executeMySQLQuery()
//    readCsvFileKotlin("C:\\Users\\kenji.a.sato\\Desktop\\insurancedb.csv")

        // make a connection to MySQL Server
//        OpenConnection()
        // execute the query via connection object

//        QueryInsert()
//        executeMySQLQuery()
    }
}

//Things done, Encapsulation

//working on:::::
// isconnected,
// remove header of csv if have header, auto create ID,
// map using lambda,
//ipaddress try catch
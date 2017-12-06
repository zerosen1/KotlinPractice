import java.sql.SQLException

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
}
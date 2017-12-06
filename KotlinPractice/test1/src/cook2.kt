package src

/**
 * A singleton class that produces cooks
 */
var cook:(String)->Unit = {s:String -> println(s+" is cooking a pizza\n")}
var cook2:(String)->Unit = {s:String -> println(s+" asdaghjgtredsdfghjkhgf")}
object CookFactory2  {
//    private constructor()
    enum class CookType {BOB, JIMMY }
//    companion
//    object{
        fun getCookInstance2(type: CookType, action:(String)->Unit ) {
            return when (type) {
                CookType.BOB -> action(type.toString())
                CookType.JIMMY -> action(type.toString())
            }
        }
    }
//}
fun main(args : Array<String>){
    println("Testing Bob")
    CookFactory2.getCookInstance2(CookFactory2.CookType.BOB, cook)
    println("Testing Jimmy")
    CookFactory2.getCookInstance2(CookFactory2.CookType.JIMMY, cook)
}
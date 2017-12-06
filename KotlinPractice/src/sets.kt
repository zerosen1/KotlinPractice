fun main(args: Array<String>) {

    var myset= setOf<Int>(1,4,8,3,7,9,3,8,8,8,8)
    println(myset)
    val action= {s:Int -> println(s)}
    myset.forEach(action)

}
fun main(args: Array<String>) {

    val fruits = listOf("banana", "avocado", "apricots", "Acerola" , "apple", "kiwi")
    fruits
            .filter { it.startsWith("a") }
            .sortedByDescending { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }

    println(b(1).a(5).i())
}
class b(val y:Int) {
     inner class a(var x: Int) {
        fun i(): Int {
            var z:Int = x
            var i:Int = y
            return (z+i)
        }
    }
}
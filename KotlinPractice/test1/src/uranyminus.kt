package src

fun main(args: Array<String>) {
    data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)

val point = Point(10, 20)
println(-point)  // prints "(-10, -20)"
}

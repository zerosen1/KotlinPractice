fun main(args: Array<String>) {
    val rectangle = Rectangle(5.0, 2.0) //no 'new' keyword required
    val triangle = Triangle(3.0, 4.0, 5.0)
    println(rectangle.isSquare)
    rectangle.printMe()
    println("Area of rectangle is ${rectangle.calculateArea()}, its perimeter is ${rectangle.perimeter}")
    println("Area of triangle is ${triangle.calculateArea()}, its perimeter is ${triangle.perimeter}")
}

abstract class Shape(val sides: List<Double>) {
    val perimeter: Double = sides.sum()
    abstract fun calculateArea(): Double

    // fun printMe()= println("class shape")
}

interface RectangleProperties {
    var isSquare: Boolean

    fun printMe ()= println("interface rectangleproperties")
}

class Rectangle(var height: Double,var length: Double):
Shape(listOf(height, length, height, length)), RectangleProperties {
    override var isSquare: Boolean = length == height
    override fun calculateArea(): Double = height * length
   // override fun printme()= println("over ride print me")
}

class Triangle(var sideA: Double,var sideB: Double,var sideC: Double) : Shape(listOf(sideA, sideB, sideC)) {
    override fun calculateArea(): Double {
        val s = perimeter / 2
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))
    }
}
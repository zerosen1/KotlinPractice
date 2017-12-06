package src

object static
{
    var x=1
    fun x():Int{
        return x
    }
}
fun instance1():Int
{
    static.x +=1
    return static.x
}
fun instance2():Int
{
    static.x +=3
    return static.x
}
fun main(args: Array<String>) {
println(static.x())
println(instance1())
println(instance2())
}
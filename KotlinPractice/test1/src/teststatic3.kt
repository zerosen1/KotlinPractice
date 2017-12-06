package src

private class static3
{
    var x=1
    fun x():Int{
        return x
    }
}

fun instance123():Int
{
    static3().x +=1
    return static3().x
}

fun instance223():Int
{
    static3().x +=3
    return static3().x
}

fun main(args: Array<String>) {
println(static3().x())
println(instance12())
println(instance22())
}
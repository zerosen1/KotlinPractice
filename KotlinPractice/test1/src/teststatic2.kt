package src

class static2
{
    var x=1
    fun x():Int{
        return x
    }
}//private, protected, internal and public

fun instance12():Int
{
    static2().x +=1
    return static2().x
}

fun instance22():Int
{
    static2().x +=3
    return static2().x
}

fun main(args: Array<String>) {
println(static2().x())
println(instance12())
println(instance22())
}
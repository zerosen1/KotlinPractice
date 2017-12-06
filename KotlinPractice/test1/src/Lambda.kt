package src

import java.util.LinkedList

fun main(args: Array<String>) {
    val sayHello = { user: String ->println("Hello, $user!")}
    sayHello("johnny")
// or with multiple parameters
    val printSummary = { user: String, score: Int -> println("User '$user' get $score points.")}
    printSummary("johnny", 123)
//:(Int)->Unit
    val mylambda= {s:Int -> println(s)}
    fun addnumber(a:Int,b:Int, action:(Int)->Unit){
        val sum = a+b
        action(sum)
    }
    addnumber(2.2.toInt(),7,mylambda)
    addnumber(2,7,{s:Int -> println(s)})

    val names = LinkedList<String>()
    names.push("kenji")
    names.push("kenjie2")
    names.push("kenji3")
    println(names)
    var x1:String = "1"
    names.forEach {x -> System.out.println(x) }
    for(i in names){println(i)}

    var mylambda2:(Int,Int)->Int = {a:Int,b:Int -> a*b}
    fun timesnumber(a:Int,b:Int,multi:(Int,Int)->Int){
        var i =0
        while(i<multi(a,b)){
            println("$i")
            ++i
        }
    }
    timesnumber(2,3,mylambda2)

}
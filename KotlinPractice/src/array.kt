fun main(args: Array<String>) {
var days = arrayOf("Mon", "Tue", "Wed", "Th", "Fri", "Sat", "Sun")
// Return the value of the first element in the array.
    println(days[0])
    println(days)
    println(days.toList())

// Change an element in the array.
days[3] = "Thur"
// Get a existing element from the array.
    println(days[3])
// Get the total number of elements in the array.
println(days.size )

    days+="Pear"
    println(days.toList())
    println(days.size)

    var myarray = Array<Int>(5){0}
//    myarray+="a" //cant add new size
        myarray[0] = 1
    println(myarray.toList())

    var mylist = listOf<String>("a","b")
//    mylist[0] = 1  // cant mutate list
        mylist+="a"
    println(mylist)

    var myarray2 = arrayOf<String>("a","b")
    myarray2[0] = "1"  // cant mutate list
    myarray2+="a"
    println(mylist)

}
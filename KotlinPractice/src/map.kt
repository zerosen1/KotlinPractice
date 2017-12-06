fun main(args: Array<String>) {
    class Person(val name: String, val id: Int)

    val friends = listOf(Person("Sue Helen", 1), Person("JR", 2), Person("Pamela", 3))
    val map = friends.associateBy(keySelector = { person -> person.id }, valueTransform = { person -> person.name })
    val map2 = friends.associateBy({ it.id }, { it.name }) // also works

    println(map) // prints: {1=Sue Helen, 2=JR, 3=Pamela}
    println(map2)
    println(map2[2])
//    map[2]="value"
    println(map.toList())
    for(key in map.keys ){
        println("The key is $key and value is ${map[key]}")
    }


}


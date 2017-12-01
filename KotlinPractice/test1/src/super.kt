fun main(args: Array<String>) {
    abstract class Foo {
        open fun f() {
            println("Foo.f()")

        }
    open var x=2
    }

    class Bar : Foo() {
        override fun f() {
            println(x)
            super.f()
            println("Bar.f()")
            println(f("23456789"))
        }
        override var x:Int=3
    fun f( x : String) : String = "{$x abcd}"
    }

    println(Bar().f())
}
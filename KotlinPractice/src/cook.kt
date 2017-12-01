interface Cook {
    val name : String
    fun cook()
}

/**
 * A singleton class that produces cooks
 */

object CookFactory {
    enum class CookType {BOB, JIMMY}

    /**
     * Called by clients to get a Cook based on the CookType
     */
    fun getCookInstance(type : CookType) : Cook
    {
        return when (type) {
            CookType.BOB -> Bob()
            CookType.JIMMY -> Jimmy()
        }
    }

    /**
     * Bob is a Cook that is private to the Factory. Only the Factory can
     * create Bob
     */
    class Bob : Cook
    {
        override val name: String
            get() = "Bob"

        override fun cook() {
            println("Bob is cooking the Longest Chard Burger\n")
        }
    }

    /**
     * Jimmy is a Cook that is private to the Factory. Only the Factory can
     * create Jimmy
     */
    private class Jimmy : Cook {
        override val name: String
            get() = "Jimmy"

        override fun cook() {
            println("Jimmy is cooking a pizza\n")
        }

    }

    //Note that we can add other cooks here also!
}

fun main(args : Array<String>){
    val bob = CookFactory.getCookInstance(CookFactory.CookType.BOB)
    val jimmy = CookFactory.getCookInstance(CookFactory.CookType.JIMMY)

    println("Testing Bob")
    CookFactory.Bob().cook()

    println("Testing Jimmy")
    jimmy.cook()
}
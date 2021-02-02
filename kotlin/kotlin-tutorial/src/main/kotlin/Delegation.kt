import kotlin.properties.Delegates

interface Base {
    fun printMe()
}

class BaseImpl(val x: Int) : Base {
    override fun printMe() {
        println(this.x)
    }
}

class Derived(b: Base) : Base by b

val myVar: String by lazy {
    "Hello"
}

class User {
    var name: String by Delegates.observable("Welcome to my house") {
        _, old, new -> println("$old -> $new")
    }
}

fun main() {
    val b = BaseImpl(10)
    Derived(b).printMe()

    println("$myVar My dear friend")

    val user = User()
    user.name = "First"
    user.name = "Second"
    user.name = "Third"
}
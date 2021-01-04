
open class ABC {
    open fun think() {
        println("Hey. I am thinking")
    }
}

class BDC: ABC() {
    override fun think() {
        super.think()
        println("Hey. I am thinking overrided")
    }

}

interface ExampleInterface {
    var myVar: Int
    fun absMethod(): String
    fun sayHello() = "Hello there"
}

class InterfaceImpl : ExampleInterface {
    override var myVar: Int = 25
    override fun absMethod() = "Happy Learning "
}

fun main() {
    BDC().think()

    val interfaceObject = InterfaceImpl()

    println("My Variable Value is = ${interfaceObject.myVar}")
    print("Calling hello(): " + interfaceObject.sayHello())

    print("Message from the Website-- ")
    println(interfaceObject.absMethod())



}
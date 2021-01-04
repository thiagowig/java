typealias Text = String
typealias Numero = Int

fun main(args: Array<String>) {

    /*
        Hello World
     */

    println("Hello World!")

    /*
        Numbers
     */
    
    val a: Int = 10000
    val d: Double = 100.00
    val f: Float = 100.00f
    val l: Long = 1000000004
    val s: Short = 10
    val b: Byte = 1

    println("Your Int Value is $a");
    println("Your Double  Value is $d");
    println("Your Float Value is $f");
    println("Your Long Value is $l");
    println("Your Short Value is $s");
    println("Your Byte Value is $b");

    /*
        Char
     */
    val letter: Char = 'A'
    print("$letter\n")

    /*
        Boolean
     */
    val bool: Boolean = true
    print("$bool\n")

    /*
        Strings
     */
    var rawString: String = "I am a raw string"
    val escapedString: String = "I am a escaped\nstring"
    print("$rawString\n")
    print("$escapedString\n")

    /*
        Arrays
     */
    val numbersArray: IntArray = intArrayOf(1, 2, 3, 4, 5)
    print("${numbersArray[2]}\n")

    /*
        Collections
     */
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3) //mutable List
    val readOnlyView: List<Int> = numbers                  // immutable list
    println("my mutable list--"+numbers)        // prints "[1, 2, 3]"
    numbers.add(4)
    println("my mutable list after addition --"+numbers)        // prints "[1, 2, 3, 4]"
    println(readOnlyView)
    //readOnlyView.clear()

    /*
        First, last, filter
     */
    val items = listOf(1, 2, 3, 4)
    println("First Element of our list----${items.first()}")
    println("Last Element of our list----" + items.last())
    println("Even Numbers of our List----" + items.filter { it % 2 == 0 })

    /*
        Map
     */
    val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
    println(readWriteMap["foo"])

    /*
        Set
     */
    val strings = hashSetOf("a", "b", "c", "c")
    println("My Set Values are$strings")

    /*
        Ranges
     */
    for(j in 1..4) {
        println("J: $j")
    }

    val i: Int = 2
    if (i in 1..10) {
        println("We've found your number")
    }


    /*
        If Else
     */
    val a01:Int = 5
    val b02:Int = 2
    var max: Int

    if (a01 > b02) {
        max = a01
    } else {
        max = b02
    }
    print("Maximum of a or b is " +max)

    /*
        When
     */
    val x01 = 7

    when (x01) {
        1 -> println("x == 1")
        2 -> {
            println("x == 2")
        }
        else -> {
            print("x is neither 1 nor 2")
        }
    }

    when (x01) {
        1,2 -> println("\nx == 1 or 2")
        else -> {
            print("\nx is neither 1 nor 2")
        }
    }

    /*
        For
     */
    val items02 = listOf(1, 2, 3, 4)
    for (i in items02) println("values of the array"+i)

    for ((index, value) in items02.withIndex()) {
        println("the element at $index is $value")
    }

    /*
        While Loop and Do-While Loop
     */
    var x03: Int = 0
    while (x03 < 10) {
        println(x03)
        x03++
    }

    x03 = 0

    do {
        x03 = x03 + 10
        println("I am inside Do block---"+x03)
    } while (x03 < 50)

    /*
        Continue and break
     */
    println("Bora começar")

    for (x in 1..10) {
        if (x == 5) {
            println("I am inside if block with value"+x+"\n-- hence it will close the operation")
            break
        } else {
            println("I am inside else block with value"+x)
            continue
        }
    }

    /*
        Working with objects
     */
    var myClass = MyClass()
    myClass.printMe()

    MyClass.MyNestedClass().printMe()
    MyClass().MyInnerClass().printMe()


    /*
        Anonymous Inner Class
     */
    var programmer :Human = object:Human {
        override fun think() {
            print("I am an example of a programmer thinking \n")
        }
    }
    programmer.think()


    /*
        Typealias
     */
    var phrase: Text = "Some string"
    var number: Numero = 123


    /*
        Constructors
     */
    val person = Person("Thiago", 22)
    person.age = 23
    println(person.firstName)
    println(person.age)

    val HUman = HUman("TutorialsPoint.com", 25)
    print("${HUman.message}"+"${HUman.firstName}"+
            "Welcome to the example of Secondary  constructor, Your Age is-${HUman.age}")
}

class HUman(val firstName: String, var age: Int) {
    val message: Text = "Hey!!!"

    constructor(name : String , age :Int ,message :String):this(name,age) {
    }
}

class Person(val firstName: String, var age: Int) {
}



class MyClass {
    private var name = "Thiago Fonseca"

    fun printMe() {
        println("My name is $name")
    }

    class MyNestedClass {

        fun printMe() {
            println("Hello from nested")
        }

    }

    inner class MyInnerClass {
        fun printMe() {
            println("Hello from inner")
        }
    }
}

interface Human {
    fun think()
}
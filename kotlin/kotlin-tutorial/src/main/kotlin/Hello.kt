
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
}

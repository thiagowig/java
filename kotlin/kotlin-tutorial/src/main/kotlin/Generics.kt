fun main() {
    val integer: Int = 10
    val number: Number = integer
    println(number)

    var bejeto01 = GenericsExample<String>("JAVA")
    var bejeto02 = GenericsExample<Int>(10)
}


class GenericsExample<out T>(input: T) {
    init {
        println("I am getting called with value: $input" )
    }
}


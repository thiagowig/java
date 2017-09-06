package br.com.ithiago


fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sumInADifferentWay(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int) {
    print("\nSum of $a and $b is ${a + b}")
}

fun main(args: Array<String>) {
    print("\nThe sum of 3 and  5 is ")
    print(sum(3, 5))

    print("\nThe sum of 5 and  5 is in a different way ")
    print(sumInADifferentWay(5, 5))

    var firstValue = 15
    var secondValue = 10
    printSum(firstValue, secondValue)
}
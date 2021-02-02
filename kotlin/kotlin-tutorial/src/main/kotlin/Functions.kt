fun main() {
    val myLambda: (String) -> Unit = {s: String -> run {
        println("$s")
    }}

    myLambda("Thiago Fonseca")
    myFunction("Cruzeiro", myLambda)
}

fun myFunction(text: String, function: (String) -> Unit) {
    function(text)
}
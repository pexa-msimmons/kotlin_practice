fun multiply(a: Int, b: Int): Int {
    return a * b
}

// Simple functions can be declared as expressions
fun sum(a: Int, b: Int): Int = a + b

fun max(a: Int, b: Int): Int = if (a > b) a else b

// Function with no return implicitly returns Unit
fun displayMax(a: Int, b: Int) {
    println(max(a, b))
}
// All exceptions in Kotlin are unchecked exceptions

fun getPercentage(n: Int): Int {
    // `throw` can be assigned to a variable
    val percentage = if (n in 1..100) {
        n
    } else{
        throw IllegalArgumentException("A percentage value must be between 0 and 100: $n")
    }

    return percentage
}

fun toIntOrNull(s: String): Int? {
    // `try/catch` expressions can be assigned to a variable
    // `s.toIntOrNull()` will do the same thing here
    val percentage = try {
        s.toInt()
    } catch(e: NumberFormatException) {
        null
    }

    return percentage
}
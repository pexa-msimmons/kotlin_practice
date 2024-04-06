// Kotlin standard library is just the Java standard library plus added extensions
// This makes Java and Kotlin very interoperable
// They are compiled into static functions
// They cannot override any existing member of the class, but they can overload a member
// Extensions are intended to be used as utility functions whilst members are seen as intrinsic to the type

// Extension functions are added to a receiver type
fun String.firstChar() = this.getOrNull(0)

// `this` keyword can be omitted
fun String.lastChar() = getOrNull(length - 1)

fun List<Int>.sum(): Int {
    var result = 0
    for (i in this) {
        result += i
    }
    return result
}

fun testExtensions() {
    // Test extensions defined above
    println("First Char: ${"abc".firstChar()}")
    println("Last Char: ${"abc".lastChar()}")
    println("Sum: ${listOf(1, 2, 3).sum()}")

    // Kotlin creates Java objects with extensions applied
    val set = setOf(1, 2, 3)
    val list = listOf(1, 2, 3)
    val map = hashMapOf(1 to "one", 2 to "two", 3 to "three")

    println(set.javaClass) // class java.util.HashSet
    println(list.javaClass) // class java.util.ArrayList
    println(map.javaClass) // class java.util.HashMap

    // --- Examples ---

    // `joinToString` is extension applied to `ArrayList` receiver
    list.joinToString(separator=", ", prefix="(", postfix=")")

    // `withIndex` is extension applied to `Iterable<T>` receiver
    for ((index, element) in list.withIndex()) println("$index: $element")

    // `until` is an `infix` function extension of `Int`, meaning it can be called in two ways:
    1.until(10)
    1 until 10

    // `to` is an `infix` function extension of a generic type `<A, B> A` which returns a `Pair<A, B>`
    1.to("one")
    1 to "one"

    // Triple quotes allow for multiline strings but string must be formatted with margin prefix and trimmed
    val s = """Testing
        |multiline string
    """.trimMargin()

    // Triple quoted strings are useful for regex since you do not need to escape special characters
    val regex = "\\d{2}".toRegex()
    val regex2 = """\d{2}""".toRegex()
}

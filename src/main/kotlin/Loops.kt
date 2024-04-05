fun loopList() {
    val list = listOf(1, 2, 3)
    for (n in list) {
        print(n)
    }

    println()

    // Enumerate list
    for ((index, n) in list.withIndex()) {
        println("$index: $n")
    }
}

fun loopRange() {
    // Inclusive range
    for (i in 1..9) {
        print(i)
    }

    println()

    // Exclusive range
    for (i in 1 until 9) {
        print(i)
    }

    println()

    // Reverse range with custom step
    for (i in 9 downTo 1 step 2) {
        print(i)
    }

    println()
}

fun loopMap() {
    // The `to` keyword creates a `Pair`
    val map = mapOf(
        1 to "one",
        2 to "two",
        3 to "three"
    )
    for ((key, value) in map) {
        println("$key = $value")
    }
}
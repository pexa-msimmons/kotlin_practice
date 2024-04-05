package org.example

enum class Color {BLUE, ORANGE, RED}

fun updateWeather(degrees: Int): Pair<String, Color> {
    // Instead of declaring individual variables, we can assign to a pair directly
    // Types can also be inferred - val (description, color)
    val (description: String, color: Color) =
        if (degrees < 10) {
            Pair("cold", Color.BLUE)
        } else if (degrees < 25) {
            Pair("warm", Color.ORANGE)
        } else {
            Pair("hot", Color.RED)
        }

    return Pair(description, color)
}

fun updateWeather2(degrees: Int): Pair<String, Color> {
    // when is similar to a switch statement in Java
    val (description, color) = when {
        degrees < 10 -> Pair("cold", Color.BLUE)
        degrees < 25 -> Pair("warm", Color.ORANGE)
        else -> Pair("hot", Color.RED)
    }

    return Pair(description, color)
}

fun updateWeather3(degrees: Int): Pair<String, Color> {
    // to can be used in place of Pair
    val (description, color) = when {
        degrees < 10 -> "cold" to Color.BLUE
        degrees < 25 -> "warm" to Color.ORANGE
        else -> "hot" to Color.RED
    }

    return Pair(description, color)
}
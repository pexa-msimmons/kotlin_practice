import Color.*

fun updateWeather(degrees: Int): Pair<String, Color> {
    // Instead of declaring individual variables, we can assign to a pair directly
    // Types can also be inferred - val (description, color)
    val (description: String, color: Color) =
        if (degrees < 10) {
            Pair("cold", BLUE)
        } else if (degrees < 25) {
            Pair("warm", ORANGE)
        } else {
            Pair("hot", RED)
        }

    return Pair(description, color)
}

fun updateWeather2(degrees: Int): Pair<String, Color> {
    // when is similar to a switch statement in Java
    val (description, color) = when {
        degrees < 10 -> Pair("cold", BLUE)
        degrees < 25 -> Pair("warm", ORANGE)
        else -> Pair("hot", RED)
    }

    return Pair(description, color)
}

fun updateWeather3(degrees: Int): Pair<String, Color> {
    // to can be used in place of Pair
    val (description, color) = when {
        degrees < 10 -> "cold" to BLUE
        degrees < 25 -> "warm" to ORANGE
        else -> "hot" to RED
    }

    return Pair(description, color)
}

fun displayWeather(degrees: Int = 15) {
    val (description, color) = updateWeather(degrees)
    println("Description $description")
    println("Color $color")
}
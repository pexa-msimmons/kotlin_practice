import kotlin.random.Random

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

fun getRandomPet() = if (Random.nextBoolean()) Dog() else Cat()

fun getSound(): String {
    val pet = getRandomPet()
    val sound: String = when(pet) {
        // Using smart cast to cast pet to dynamic type
        // `is` is equivalent to `instanceof` in Java
        is Cat -> pet.meow()
        is Dog -> pet.woof()
        else -> "---"
    }

    return sound
}

// Move variable declaration directly into when
// Allows for function to be defined as expression
fun getSound2(): String = when(val pet = getRandomPet()) {
    // Using smart cast to cast pet to dynamic type
    is Cat -> pet.meow()
    is Dog -> pet.woof()
    else -> "---"
}

// Multi value conditional
fun respondToInput(input: String) = when(input) {
    // Returns "A" if input is either "y" or "yes"
    "y", "yes" -> "A"
    "n", "no" -> "B"
    else -> "C"
}

// A valid identifier is a non-empty string that starts with a letter or underscore and
// consists of only letters, digits and underscores.
fun isValidIdentifier(s: String): Boolean {
    if (s.isEmpty()) {
        return false
    }

    if (!when(s[0]) {
        '_' -> true
        in 'a'..'z' -> true
        in 'A'..'Z' -> true
        else -> false
    }) return false

    for (c in s) {
        if (!when (c) {
                '_' -> true
                in 'a'..'z' -> true
                in 'A'..'Z' -> true
                in '1'..'9' -> true
                else -> false
            }
        ) return false
    }

    return true
}

// A valid identifier is a non-empty string that starts with a letter or underscore and
// consists of only letters, digits and underscores.
fun isValidIdentifier2(s: String): Boolean {
    fun isValidChar(c: Char) = c == '_' || c.isLetterOrDigit()

    if (s.isEmpty() || !(s[0] == '_' || s[0].isLetter())) return false

    for (c in s) {
        if (!isValidChar(c)) return false
    }

    return true
}
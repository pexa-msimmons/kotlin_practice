import kotlin.random.Random

import Color.*

// --- if else ---

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

fun getRandomPet() = if (Random.nextBoolean()) Dog() else Cat()

// --- when ---

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

// --- Multi Value Conditional ---

fun respondToInput(input: String) = when(input) {
    // Returns "A" if input is either "y" or "yes"
    "y", "yes" -> "A"
    "n", "no" -> "B"
    else -> "C"
}


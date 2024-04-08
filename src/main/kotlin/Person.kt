// Kotlin automatically defines public variables from definition
class Person (val name: String, val age: Int) {
    fun isOlder(ageLimit: Int) = age > ageLimit
}
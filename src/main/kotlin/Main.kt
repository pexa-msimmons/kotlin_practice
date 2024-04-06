fun main() {
    println("Hello World!")

    val person = Person("Alice", 27)
    // Template string
    println("Name: ${person.name}")
    println("Age: ${person.age}")

    val x = sum(5, 10)
    println(x)

    val y = multiply(5, 10)
    println(y)

    // Destructure pair with type inference
    val (description, color) = updateWeather(8)
    println("Description: $description")
    println("Color: $color")

    // Read only reference to mutable object
    val list: MutableList<String> = mutableListOf("Kotlin")
    list.add("Java")
    // Read only reference to immutable object
    val list2: List<String> = listOf("Kotlin")

    loopList()
    loopRange()
    loopMap()

    println(getSound())
    println(getSound2())

    testExtensions()
}

/* Using args:
fun main(args: Array<String>) {
    val name = if (args.size > 0) args[0] else "Kotlin"
    println(name)

    val arg = args.getOrNull(0)
    val name2 = if (arg) arg else "Kotlin"
    println("Hello, ${name2}!")
}
*/
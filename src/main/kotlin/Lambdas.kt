fun lambdaExamples() {
    /// --- Syntax ---
    val list = listOf(1,2,3,4,5)

    // Lambda inside parenthesis
    list.any({i: Int -> i > 0})
    // Lambda outside parenthesis
    list.any() {i: Int -> i > 0}
    // Remove parenthesis entirely
    list.any {i: Int -> i > 0}
    // Type can be inferred
    list.any {i -> i > 0}
    // If lambda has only one argument, you can use `it`
    list.any {it > 0}

    // --- mapValues ---
    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    // Destructure first element
    map.mapValues { (key, value) -> println("$key: $value") }

    // --- filter ---
    val even = list.filter {it % 2 == 0}
    println("Even values $even")

    // --- map ---
    val squared = list.map { it * it }
    println("Squared values: $squared")

    // --- any ---
    val hasEven = list.any { it % 2 == 0 }
    println("Has even: $hasEven")

    // --- all ---
    val areAllEven = list.all { it % 2 == 0 }
    println("All even: $areAllEven")

    // --- none ---
    val areNoneEven = list.none { it % 2 == 0 }
    println("None even: $areNoneEven")

    // --- find ---
    var firstEven = list.find { it % 2 == 0 }
    println("First even: $firstEven")

    // Same as find
    firstEven = list.firstOrNull { it % 2 == 0 }

    // Same as find but throws an exception if no value is found
    firstEven = list.first { it % 2 == 0 }

    // --- count ---
    val evenCount = list.count { it % 2 == 0}
    println("Number of even: $evenCount")

    // --- partition ---
    val (evenPartition, oddPartition) = list.partition { it % 2 == 0}
    println("Even: $evenPartition, Odd: $oddPartition")

    // --- groupBy ---
    val people = listOf(
        Person("John", 15),
        Person("Andrew", 15),
        Person("Alice", 20),
        Person("Jacinta", 20),
        Person("David", 30),
        Person("Emma", 30),
    )

    val ageGroupMap = people.groupBy { it.age }
    ageGroupMap.mapValues { (age, group) -> println("Age: $age, Group: ${group.map { it.name }}") }

    // --- associate ---
    val associateMap = list.associate { 'a' + it - 1 to 10 * it }
    println(associateMap)

    // --- flatten ---
    val ageGroupList = ageGroupMap.values
    val people2 = ageGroupList.flatten()
    people2.map { println("Name: ${it.name}, Age: ${it.age}") }

    // --- maxBy ---
    val personWithMaxAge = people.maxBy { it.age }
    println("Person with max age: ${personWithMaxAge.name}")

    // --- getOrElse ---
    val four = map.getOrElse(4) {"four"}

    // --- Member References ---
    // Instead of defining lambdas in place, we can define a function then pass a reference to the function
    // Useful for re-usability
    fun isEven(i: Int): Boolean = i % 2 == 0
    list.any(::isEven)

    // --- run ---
    // run executes the lambda and returns the result
    val result = run {
        println("Running lambda")
        10
    }
    println(result)
}

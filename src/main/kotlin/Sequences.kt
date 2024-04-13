fun sequenceExamples() {
    // Sequence with initial seed and next lambda
    val sequence1 = generateSequence(0) { it + 1 }
    val list1 = sequence1.take(5).toList()
    println(list1)

    // Same result as above
    // Yield allows for more options
    val sequence2 = sequence {
        var x = 0
        while (true) yield(x++)
    }
    val list2 = sequence2.take(5).toList()
    println(list2)

    // Sequences are useful for optimising chained operations on collections
    // If we convert the collection to a sequence this will eliminate certain intermediary steps
    // i.e. Each element is lazily evaluated instead of generating a new collection for each lambda
    val list3 = 1..10
    val list4 = list3.asSequence().map { it * it }.filter { it < 50 }.toList()
    println(list4)
}
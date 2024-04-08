fun castExamples() {
    val foo: String = "abc"

    // If `foo` was type `any`, then it would be automatically smart-cast to type `String`
    // We don't need to write `val bar = foo as String`
    if (foo is String) foo.uppercase()

    // Safe cast will return `null` if `foo` is not a `String`
    (foo as? String)?.uppercase()
}
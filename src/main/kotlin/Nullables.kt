// Kotlin differentiates between nullable and non-nullable types
// This is to make nullability a compile-time problem instead of a runtime problem (avoid runtime exceptions)

fun testNullable() {
    val s1: String = "non-nullable"
    val s2: String? = null
    val s3: String? = "nullable"

    s1.length
    // s2.length // won't compile

    // Safe access operator - returns nullable result
    val length1: Int? = s2?.length
    // Equivalent to this
    val length2: Int? = if (s2 != null) s2.length else null

    // Default value - using elvis operator
    val length3: Int = s2?.length ?: 0
    // Equivalent to this
    val length4: Int = if (s2 != null) s2.length else 0

    // Compiler control flow analysis will smart cast reference to a non-nullable type
    if (s2 == null) return
    val length5: Int = s2.length

    // Not nullable assertion will throw `NullPointerException` if reference is null
    // Nullable member is then smart cast to non-nullable type
    val length6: Int = s2!!.length
}
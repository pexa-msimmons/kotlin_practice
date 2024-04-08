import kotlin.random.Random

// val - implements getter
// var - implements getter and setter
class Contact (val name: String, var address: String) {
    // Custom val property
    val foo: Int
        get() {
            return Random.nextInt()
        }

    // Custom var property
    // `field` refers to the internally stored value
    var bar = 4
        get() {
            return field * field
        }
        set(value) {
            field = value / 2
        }

    // Lazy properties are only computed once on their first access
    val lazyProperty: String by lazy {
        println("computed")
        "hello"
    }

    // `lateinit` properties allow us to define non-nullable properties that are not immediately initialised
    // This is useful for frameworks that use dependency injection to inject dependencies at initialisation time
    // Without `lateinit` we would have to define nullable properties and access them with the safe access operator
    private lateinit var person: Person

    fun init() {
        person = Person("James", 30)
    }

    fun display() {
        // Note, this will throw an `UninitializedPropertyAccessException` if `init` has yet to be called
        println(person.name)
    }
}

// --- Extension Properties ---

val String.lastIndex: Int
    get() = this.length - 1

val String.indices: IntRange
    get() = 0..lastIndex

fun propertyExamples() {
    val s = "abc"
    println("Last index: ${s.lastIndex}")
    println("Indices: ${s.indices}")

    val contact = Contact("John", "Melbourne")
    contact.lazyProperty
    contact.lazyProperty
}

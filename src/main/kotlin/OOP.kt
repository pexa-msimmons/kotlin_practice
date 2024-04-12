// Note, package name does not need to follow directory structure in Kotlin
// By default, members are public and final
// A member must be declared `open` if it can be overridden

// --- Constructors ---

// Kotlin automatically defines public properties from primary constructor parameters that are declared with val or var
// You can declare private properties in the constructor or initialise them in the constructor body
class Person (val name: String, val age: Int, private val height: Int, weight: Int) {

    private val weight: Int

    // Primary constructor body (if needed)
    init {
        this.weight = weight
        println("Primary constructor")
    }

    // Do not use val or var in secondary constructor
    // Primary constructor must be called from secondary constructor
    constructor(name: String, age: Int) : this(name, age, 180, 80) {
        println("Secondary constructor")
    }

    fun isOlder(ageLimit: Int) = age > ageLimit
}

// --- Inheritance ---

// Base classes must be declared `open` for extension
open class Parent(val name: String)
class Child(name: String, private val param: Int) : Parent(name) {

    constructor(name: String) : this(name, param=2)
}

// Warning, do not reference `open` properties in a parent class' constructor
// Linter will actually warn you not to do this
open class Parent2 {
    open val foo = 1

    init {
        println(foo)
    }
}

class Child2: Parent2() {
    override val foo = 2
}

// --- Data Classes ---

// Data classes generate useful methods such as `equals`, `hashCode`, `copy`, `toString`
data class Foo(val first: Int, val second: Int)

// --- Sealed Classes ---

// Adding `sealed` modifier to a class means we do not need to add an `else` in the below `eval` function
// The compiler knows that only classes within this module can inherit from Eval
sealed class Expr
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()

fun eval(e: Expr): Int = when(e) {
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
}

// --- object expression ---

// Used to create Singleton objects
// Useful when you need an anonymous class with more than one function
// If you only need to define a single function, just use a lambda

object Bar {
    // We can define constants inside objects
    const val MY_CONST = 5

    fun bar() {
        println("bar")
    }
}

// --- companion expression ---

// There is no static keyword in Kotlin
// Instead, we can use companion objects to define static methods and constants
// Companion objects can implement interfaces

interface Factory<T> {
    fun create(): T
}

class A private constructor() {

    companion object {
        // Equivalent to a final static variable
        // ie. This is a compile-time constant
        const val MY_CONST = 5

        fun a(): Int = 1
    }
}

class B private constructor() {

    companion object: Factory<B> {
        override fun create() = B()
    }
}

// --- Generics ---

// In this case the function only accepts a list of integers
fun printInts(ints: List<Int>) {
    println(ints)
}

// We can make the function itself generic
fun <T> printGeneric(generic: List<T>) {
    println(generic)
}

// This function only accepts lists of non-nullable types
// The generic type `T` extends the non-nullable type `Any`
fun <T : Any> printGenericNonNullable(generic: List<T>) {
    println(generic)
}

// This function only accepts lists of numbers
fun <T : Number> printNumbers(generic: List<T>) {
    println(generic)
}


// --- Test ---

fun oopExamples() {
    // This will print 0
    // The getter for the child class `foo` property has not been initialised,
    // yet it is invoked in the parent class constructor
    val child2 = Child2()

    val foo1 = Foo(1, 2)
    // Makes a copy of `foo1`, but replaces the `first` argument
    val foo2 = foo1.copy(first=2)
    val foo3 = Foo(2, 2)
    // Data classes can be compared for equality
    println(foo2 == foo3) // true
    // If you need a reference equality check between data class objects
    println(foo2 === foo3) // false

    val person1 = Person("Sam", 20)
    val person2 = Person("Sam", 20)
    // For non-data classes, `==` performs a reference equality check
    println(person1 == person2) // false

    eval(Sum(Num(1), Num(3)))

    // Call companion object function (static method)
    println(A.a())
    // Access companion object constant
    println(A.MY_CONST)

    // Call singleton method
    Bar.bar()
}
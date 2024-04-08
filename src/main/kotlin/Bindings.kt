fun bindingExamples() {
    // This is an unbound reference since it is not bound to any particular instance
    // We can call it with any Person instance
    val isOlder: (Person, Int) -> Boolean = Person::isOlder
    val alice = Person("Alice", 29)
    isOlder(alice, 30)

    // This is a bound reference since is bound to a specific instance
    val isOlder2: (Int) -> Boolean = alice::isOlder
    isOlder2(30)
}
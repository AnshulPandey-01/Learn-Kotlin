import kotlin.random.Random

// private -> only visible inside the class
// protected -> only visible inside the class and its subclasses
// internal -> only visible inside the same module
// public -> visible everywhere
// if you don't specify anything, it's public by default

class Circle (
    var radius: Double
) : Shape("Circle") {

    // companion object -> similar to static in java
    companion object {
        fun randomCircle() : Circle {
            return Circle(Random.nextDouble(1.0, 10.0))
        }
    }

    init {
        println("$name with radius $radius is created")
    }

    override fun area() = ImportantNumbers.PI * radius * radius

    override fun perimeter() = 2 * ImportantNumbers.PI * radius
}
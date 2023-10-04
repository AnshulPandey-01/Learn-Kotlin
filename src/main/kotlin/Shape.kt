// open -> so that other classes can inherit from this class
// abstract -> so that we can't create object of this class. Now we can only inherit from this class
abstract class Shape(
    var name: String
) {

    init {
        println("Shape $name is created")
    }

    abstract fun area() : Double
    abstract fun perimeter() : Double

    fun changeName(name: String) {
        this.name = name
    }

}
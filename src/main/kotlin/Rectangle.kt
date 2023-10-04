class Rectangle(
    val length: Double,
    val breadth: Double
) : Shape("Rectangle") {

    constructor(length: Double) : this(length, length)

    constructor(length: Int, breadth: Int) : this(length.toDouble(), breadth.toDouble())

    init {
        println("$name with length $length and breadth $breadth is created")
    }

    override fun area() = length * breadth

    override fun perimeter() = 2 * (length + breadth)

    fun isSquare() = length == breadth

}
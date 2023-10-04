class Triplet<A : Any, B : Any, C : Any> (
    var first: A,
    var second: B,
    var third: C
) {
    fun printTypes() {
        println("First: ${first::class}, Second: ${second::class}, Third: ${third::class}")
    }
}
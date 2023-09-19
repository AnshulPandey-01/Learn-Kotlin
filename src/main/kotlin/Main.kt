import kotlin.math.pow

// const val -> compile-time constant (immutable)
const val X = 7

fun main(args: Array<String>) {
    println("Hello World!\n")

//    stringComparison()
//    ifElseEquation()
//    takeInput()
//    loops1()
//    loops2()
//    arrayExample()
//    lists()
//    whenExample()
//    println("2 raise to the power of 5 is ${getPow1(2, 5)}")
//    println("3 raise to the power of 5 is ${getPowShortFormat(3, 5)}")
//    println("4 raise to the power of 3 is ${getPowMiniFormat(4, 3)}")

//    varargDefaultAndNamedParameterExample()
//    extensionFunctionExample()

}

fun stringComparison() {
    var str1 : String = "hello"
    var str2 : String = String("Hello".toCharArray())

    println(str1.equals(str2, false))
}

fun ifElseEquation() {
    // var -> mutable
    var y = 5
    ++y;
//    y++;

    // val -> runtime constant (immutable)
    val z : Int = if (X > y) 3 else 11
    println("z = $z")
}

fun takeInput() {
    print("Enter your num1: ")
    val num1Text = readLine()

    /*
     Here, we use the !! operator, known as the "double-bang" or "not-null assertion" operator.
      It's used to assert that num1Text is not null, and if it is null, it will throw a NullPointerException.
      So, this code assumes that num1Text is not null.
     */
    val num1 : Int = num1Text!!.toInt()

    print("Enter your num2: ")
    val num2Text = readLine()
    /*
     Here, we use the safe call operator (?.).
      This means that if num2Text is null, the expression will short-circuit, and the entire expression will evaluate to null.
      If num2Text is not null, it attempts to convert it into an integer using the toInt() function.

     `?:` This is the Elvis operator.
       It's used to provide a default value when the expression on its left-hand side (in this case, num2Text?.toInt()) is null.
       If the expression on the left is null, it evaluates to the value on the right (in this case, 0).
      */
    val num2 : Int = num2Text?.toInt() ?: 0

    println("\nnum1 + num2 = ${num1 + num2}")
}

fun loops1() {
    val names : Array<String> = arrayOf("Jon", "Jack", "Jill", "Jane")

    val len = names.size
    var i = 0
    while (i < len) {
        println("name at $i is ${names[i]}")
        i++
    }

    println()

    for (name in names) {
        println(name)
    }
}

fun loops2() {
    val a = 'a'
    val z = 'z'
    for (c in a..z)
        print("$c ")

    println()

    // .. (range operator) is inclusive i.e. it will include 5
    // we can also use 'until' which is exclusive i.e. it will not include 5
    for (i in 0..5) {
        print("number -> ")
        println("$i ")
    }

    println()

    for (i in 15 downTo 1 step 3)
        print("$i ")
}

fun arrayExample() {
    // Arrays have fixed size but elements can be updated
    val names = arrayOf("Jon", "Jack", "Jill", "Jane")
    names[0] = "John"
    println(names.contentToString())
}

fun lists() {
    val names : List<String> = listOf("Jon", "Jack", "Jill", "Jane")
//    names[0] = "John" -> will create error as list is immutable neither we can add nor update elements in it
    println(names)

    // In mutableList we can add, update and remove elements from it
    val cities : MutableList<String> = mutableListOf("London", "Rome", "Berlin")
    cities[0] = "Paris"
    cities.add("Mumbai")
    println(cities)

    /*
     We can also create empty list
     1. ->  val emptyList = mutableListOf<Int>()
     2. -> val emptyList : MutableList<Int> = mutableListOf()
     */
    val emptyList = mutableListOf<Int>()
    for (i in 1..10) emptyList.add(i)
    println(emptyList)
}

fun whenExample() {
    val x = 1
    if (x == 1) {
        println("x is 1")
    } else if (x == 2) {
        println("x is 2")
    } else if (x == 3 || x == 4) {
        println("x is not 1 or 2")
    } else if (x in 5..10) {
        println("x is between 5 and 10")
    } else {
        println("x is greater than 10")
    }

    // Above if-else can be written as below.
    // when is similar to switch in java. Once the condition is satisfied, it will not check for other conditions.
    // We can use when to assign value to variable.
    val z = when (x) {
        1 -> {
            println("x is 1")
            1
        }
        2 -> println("x is 2")
        3, 4 -> println("x is 3 or 4")
        in 5..10 -> println("x is between 5 and 10")
        else -> println("x is greater than 10")
    }

    println("z is $z")
}

fun getPow1(num : Int, pow : Int) : Int {
    var result = 1
    for (i in 1..pow) {
        result *= num
    }
    return result
}

fun getPowShortFormat(num : Int, pow : Int) : Int = num.toDouble().pow(pow).toInt()

// returns double value as we are not converting result to other type
// we can also do println if we don't want to return value
fun getPowMiniFormat(num : Int, pow : Int) = num.toDouble().pow(pow)

// Nested function -> The inner can only be called from the outer function
fun varargDefaultAndNamedParameterExample() {
    fun varargExample(vararg nums : Int, identifier : String = "number") {
        println(identifier)
        for (num in nums) {
            println("$identifier $num")
        }
    }

    val array = intArrayOf(31, 20, 6, 44)
    // vararg and default parameter are optional
    varargExample()
    varargExample(2, -3, *array, 11)
    varargExample(identifier = "none")
    varargExample(2, 3, 4, identifier = "item")
    // when we use named parameter, we can change the order of parameters
    // but when we do this with vararg, we have to pass it using the array type function
    varargExample(identifier = "value", nums = intArrayOf(2, -3, *array, 11))
}

// Extension function -> add new functionality to existing class or an interface without having to inherit from them.
fun extensionFunctionExample() {
    // Here we are extending Int class and adding new functionality to it.
    fun Int.isOdd() : Boolean {
        return this % 2 != 0
    }

    val num = 7
    println("Is $num odd? ${num.isOdd()}")
}

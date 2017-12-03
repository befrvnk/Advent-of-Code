package main.days

import printSolution
import readInput

private fun first(input: String): Int {
    val number = input.toInt()
    val radius = calcRadius(number)
    val elementsInOutline = Math.abs(calcNumberOfElements(radius - 1) - number)
    return calcOffsetToCenter(radius, elementsInOutline)
}

private fun calcOffsetToCenter(radius: Int, elementsInOutline: Int): Int {
    val diameter = radius * 2 - 1
    // each side has diameter - 1 elements for this algorithm
    // that's because (diameter - 1) * 4 is the complete outline
    // each side starts with an offset of 1 as it only has diameter - 1 elements
    val side = (elementsInOutline % (diameter - 1)) + 1
    val sideOffset = Math.abs(side - radius)
    // radius starts at 1; therefore you have to subtract 1 
    return (radius - 1) + sideOffset
}

private fun calcRadius(number: Int): Int {
    var radius = 0
    do {
        radius++
    } while (calcNumberOfElements(radius) < number)
    return radius
}

// recursively count from outside to the center
private fun calcNumberOfElements(radius: Int): Int {
    return if (radius == 1) 1 else calcOutline(radius) + calcNumberOfElements(radius - 1)
}

private val calcOutline = { radius: Int -> (radius - 1) * 8 }

private fun second(input: String): Int {
    return 0
}

fun main(args: Array<String>) {
    val input = readInput("day3.txt")
    printSolution(first(input).toString(), second(input).toString())
}

package main.days

import printSolution
import readInput

private fun first(input: String): Int {
    val instructions = readIntFromEachLine(input).toMutableList()
    var steps = 0
    var position = 0
    while (position >= 0 && position < instructions.size) {
        position += instructions[position]++
        steps++
    }
    return steps
}

private fun second(input: String): Int {
    val instructions = readIntFromEachLine(input).toMutableList()
    var steps = 0
    var position = 0
    while (position >= 0 && position < instructions.size) {
        position += if (instructions[position] >= 3) instructions[position]-- else instructions[position]++
        steps++
    }
    return steps
}

private fun readIntFromEachLine(input: String): List<Int> {
    val lines = input.split(Regex("\\r?\\n"))
    return lines
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
            .toMutableList()
}

fun main(args: Array<String>) {
    val input = readInput("day5.txt")
    printSolution(first(input).toString(), second(input).toString())
}

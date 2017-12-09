package main.days

import printSolution
import readInput

private fun first(input: String): Int {
    val lines = input.split(Regex("\\r?\\n"))
    return lines
            .filter { it.isNotEmpty() }
            .map { it.split(Regex("\\W+")) }
            .filter { it.toMutableList().distinct().size == it.size }.size
}

private fun second(input: String): Int {
    val lines = input.split(Regex("\\r?\\n"))
    return lines
            .filter { it.isNotEmpty() }
            .map { it.split(Regex("\\W+")) }
            .map { line -> line.map { word -> word.map { char -> char.toInt() }.sorted() }}
            .filter { it.toMutableList().distinct().size == it.size }.size
}

fun main(args: Array<String>) {
    val input = readInput("day4.txt")
    printSolution(first(input).toString(), second(input).toString())
}

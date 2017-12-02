package main.days

import printSolution
import readInput

private fun first(input: String): Int {
    val lines = input.split(Regex("\\r?\\n"))
    return lines
            .filter { it.isNotEmpty() }
            .map { it.split(Regex("\\W+")) }
            .map { line -> line.map { it.toInt() }}
            .map { line -> line.max()!! - line.min()!! }
            .sum()
}

private fun second(input: String): Int {
    val lines = input.split(Regex("\\r?\\n"))
    return lines
            .filter{ it.isNotEmpty() }
            .map { it.split(Regex("\\W+")) }
            .map { line -> line.map { it.toInt() } }
            .map { line -> line.filter { element ->
                val mutableLine = line.toMutableList()
                mutableLine.remove(element)
                mutableLine.any { it -> it % element == 0 || element % it == 0 }
            } }
            .map { line -> line.max()!! / line.min()!!}
            .sum()
}

fun main(args: Array<String>) {
   val input = readInput("day2.txt")
    printSolution(first(input).toString(), second(input).toString())
}
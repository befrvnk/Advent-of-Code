package main.days

import printSolution
import readInput

private fun first(input: String): Int {
    return captcha(input, { (it + 1) % input.length})
}

private fun second(input: String): Int {
    require(input.length % 2 == 0) { "length of the input has to be even" }
    return captcha(input, { (it + input.length / 2) % input.length })
}

private fun captcha(input: String, validationPosition: (index: Int) -> Int): Int {
    val digits = input.map { Character.digit(it, 10)}
    return digits
            .filterIndexed { index, digit -> digit == digits[validationPosition(index) % input.length] }
            .sum()
}

fun main(args: Array<String>) {
    val input = readInput("day1.txt")
    printSolution(first(input).toString(), second(input).toString())
}

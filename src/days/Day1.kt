package days

import INPUT_DAY1
import printSolution

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
    printSolution(first(INPUT_DAY1).toString(), second(INPUT_DAY1).toString())
}

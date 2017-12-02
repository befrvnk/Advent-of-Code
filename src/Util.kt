import java.io.File

fun printSolution(first: String, second: String) {
    print(first + "\n" + second)
}

fun readInput(fileName: String): String {
    return File("src/main/input/" + fileName).readText()
}

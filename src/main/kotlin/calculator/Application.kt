package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun validateCustomDelimiter() {
}

fun validateNumberCandidate(parsedInput: List<String>) {
}

fun calc(calcPart: String): Int {
    return calcPart.map { it.digitToInt() }.sumOf { it }
}

fun main() {


    val delimiter = Delimiter(listOf(",", ":"))

    val input = readLine()
    val pattern = Regex("""^(?://(.+)\\n)?(.*)$""")

    val match = pattern.find(input) ?: throw IllegalArgumentException("[ERROR]커스텀 구분자 지정 형식 오류")

    val customDelimiter = match.groupValues[1]
    try {
        validateCustomDelimiter()
    } catch (e: IllegalArgumentException) {
        println(e)
    }

    delimiter.addDelimiter(customDelimiter)
    val calcPart = match.groupValues[2]
    val parsedInput = delimiter.splitInput(calcPart)


    try {
        validateNumberCandidate(parsedInput)
    } catch (e: IllegalArgumentException) {
        println(e)
    }

    val result = calc(calcPart)
    printResult(result)
}

fun printResult(result: Int) {
    print("결과 : $result")
}

data class Delimiter(var delimiters: List<String>) {
    fun addDelimiter(delimiter: String) {
        this.delimiters += delimiter
    }

    fun splitInput(input: String): List<String> {
        return input.split(*delimiters.toTypedArray())
    }

}


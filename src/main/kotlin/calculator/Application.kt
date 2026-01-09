package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun validateCustomDelimiter(delimiters: Delimiters, customDelimiter: String) {
    if (customDelimiter in delimiters.delimiters) {
        throw IllegalArgumentException("[ERROR] 커스텀 구분자가 이미 구분자로 존재합니다.")
    }
}

fun validateNumberCandidate(candidate: List<String>) {
    candidate.forEach {
        it.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] 잘못된 숫자입력입니다.")
    }
}

fun calc(calcPart: List<String>): Int {
    return calcPart.map { it.toInt() }.sumOf { it }
}

fun main() {


    val delimiters = Delimiters(listOf(",", ":"))

    val input = readLine()
    val pattern = Regex("""^(?://(.+)\\n)?(.*)$""")

    val match = pattern.find(input)
        ?: throw IllegalArgumentException("[ERROR]커스텀 구분자 지정 형식 오류")


    val customDelimiter = match.groupValues[1]
    try {
        validateCustomDelimiter(delimiters, customDelimiter.trim())
    } catch (e: IllegalArgumentException) {
        println(e)
    }

    delimiters.addDelimiter(customDelimiter)
    val calcPart = match.groupValues[2]
    val parsedInput = delimiters.splitInput(calcPart)


    try {
        validateNumberCandidate(parsedInput)
    } catch (e: IllegalArgumentException) {
        println(e)
    }

    val result = calc(parsedInput)
    printResult(result)
}

fun printResult(result: Int) {
    print("결과 : $result")
}

data class Delimiters(var delimiters: List<String>) {
    fun addDelimiter(delimiter: String) {
        if (delimiter == "")
            this.delimiters += delimiter
    }

    fun splitInput(input: String): List<String> {
        return input.split(*delimiters.toTypedArray())
    }

}


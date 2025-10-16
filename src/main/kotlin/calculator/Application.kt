package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val inputString = readUserString()
    val numList = extractNumList(inputString)
}
fun extractNumList(input: String): List<Int> {
    if(input.isEmpty()) return listOf(0)
    val strNumList = input.split(",", ":")
    val intNumList = mutableListOf<Int>()
    for(strNum in strNumList) {
        intNumList += strNum.toInt()
    }
    return intNumList
}

fun readUserString(): String {
    return readLine()
}
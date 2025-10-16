package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val inputString = readUserString()
    val cumstomDlmt = extractCustomDelimiter(inputString)
    val numList = extractNumList(inputString)
    val sum = sumNumList(numList)
    println("결과: $sum")
}

fun sumNumList(numList: List<Int>) = numList.sumOf{it}

fun extractNumList(input: String): List<Int> {
    if(input.isEmpty()) return listOf(0)
    val strNumList = input.split(",", ":")
    val intNumList = mutableListOf<Int>()
    for(strNum in strNumList) {
        intNumList += strNum.toInt()
    }
    return intNumList
}

fun extractCustomDelimiter(input: String) :String?{
    val customDlmtRegex = Regex("^//(.*?)\\n")
    val match = customDlmtRegex.find(input)
    val customDlmt = match?.groupValues?.get(1)
    return customDlmt
}

fun readUserString(): String {
    return readLine()
}
package calculator
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val inputString = readUserString()
    val calculator = StringCalculator()
    val result = calculator.calculate(inputString)
    println("결과 : $result")
}

fun readUserString(): String {
    return readLine()
}
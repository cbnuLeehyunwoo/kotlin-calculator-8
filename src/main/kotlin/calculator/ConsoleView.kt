package calculator
import camp.nextstep.edu.missionutils.Console.readLine

class ConsoleView {
    fun readInput(): String? {
        println("덧셈할 문자열을 입력해 주세요.")
        return readLine()
    }
    fun printResult(result : Double) = println("결과 : ${ result.toSmartString() }")

    private fun Double.toSmartString() : String {
        return if(this == this.toInt().toDouble())  {
            this.toInt().toString()
        } else {
            this.toString()
        }
    }
}
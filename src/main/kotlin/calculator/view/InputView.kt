package calculator.view

import camp.nextstep.edu.missionutils.Console


private const val INPUT_GUIDE = "덧셈할 문자열을 입력해 주세요."


object InputView {
    fun readInput(): String {
        println(INPUT_GUIDE)
        return Console.readLine()
    }
}
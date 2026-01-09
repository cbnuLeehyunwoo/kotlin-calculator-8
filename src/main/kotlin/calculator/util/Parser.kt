package calculator.util

import calculator.model.CalculatorConstants.BASIC_DELIMITERS
import calculator.model.CalculatorConstants.PATTERN
import calculator.model.Delimiters

object Parser {
    val div = Delimiters(BASIC_DELIMITERS)

    fun getCustomDelimiterAndCalcPart(input: String): Pair<String, String> {
        val match = PATTERN.find(input)
            ?: throw IllegalArgumentException("[ERROR]커스텀 구분자 지정 형식 오류")
        val customDelimiter = match.groupValues[1]
        div.addDelimiter(customDelimiter)
        val calcPart = match.groupValues[2]
        return customDelimiter to calcPart
    }

    fun getNumberCandidates(calcPart: String): List<String> {
       return calcPart.split(*div.delimiters.toTypedArray())
    }
}
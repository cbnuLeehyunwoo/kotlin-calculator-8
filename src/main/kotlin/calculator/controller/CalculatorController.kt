package calculator.controller

import calculator.model.Calculator
import calculator.model.Delimiters
import calculator.model.Validator
import calculator.util.Parser
import calculator.view.InputView
import calculator.view.OutputView

class CalculatorController(
    val calculator: Calculator,
    val delimiters: Delimiters
) {

    fun run() {
        val input = InputView.readInput()

        val parsedInput = Parser.getCustomDelimiterAndCalcPart(input)

        val safeCustomDelimiter = getSafeCustomDelimiter(parsedInput.first)
        delimiters.addDelimiter(safeCustomDelimiter.trim())

        val toCalcNumbers = delimiters.splitInput(parsedInput.second)
        val safeNumbers = getSafeNumbers(toCalcNumbers)

        val result = calculator.add(safeNumbers)
        OutputView.printResult(result)
    }


    fun getSafeCustomDelimiter(customDelimiter: String): String {
        try {
            Validator.validateCustomDelimiter(customDelimiter.trim())
        } catch (e: IllegalArgumentException) {
            throw e
        }
        return customDelimiter
    }

    fun getSafeNumbers(numbers: List<String>): List<Int> {
        try {
            Validator.validateNumberCandidate(numbers)
        } catch (e: IllegalArgumentException) {
            throw e
        }
        return numbers.map { it.toInt() }
    }
}
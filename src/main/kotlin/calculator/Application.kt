package calculator

import calculator.controller.CalculatorController
import calculator.model.Calculator
import calculator.model.CalculatorConstants.BASIC_DELIMITERS
import calculator.model.Delimiters


fun main() {
    val delimiters = Delimiters(BASIC_DELIMITERS)
    val calculator = Calculator()
    val controller = CalculatorController(calculator, delimiters)
    controller.run()
}


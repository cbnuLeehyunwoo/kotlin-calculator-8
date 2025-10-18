package calculator

class CalculatorController (
    private val calculator: StringCalculator,
    private val view: ConsoleView
 ){
    fun run() {
        val input = view.readInput()
        val result = calculator.calculate(input)
        view.printResult(result)
    }
}
package calculator

fun main() {
    val parser = StringParser()
    val calculator = StringCalculator(parser)
    val view = ConsoleView()
    val controller = CalculatorController(calculator, view)
    controller.run()
}

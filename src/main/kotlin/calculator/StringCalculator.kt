package calculator

class StringCalculator (
    private val parser: StringParser
){
    fun calculate(input: String?): Double {
        if(input.isNullOrEmpty()) return 0.0
        val doubleNumList = parser.parse(input)
        return sumNumList(doubleNumList)
    }
    private fun sumNumList(numList: List<Double>) = numList.sumOf{it}
}
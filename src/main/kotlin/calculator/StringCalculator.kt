package calculator

class StringCalculator (
    private val parser: StringParser = StringParser()
){
    fun calculate(input: String?): Int {
        if(input.isNullOrEmpty()) return 0
        val intNumList = parser.parse(input)
        return sumNumList(intNumList)
    }
    private fun sumNumList(numList: List<Int>) = numList.sumOf{it}
}
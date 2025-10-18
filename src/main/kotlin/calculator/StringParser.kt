package calculator

class StringParser {
    private var validChars = "0123456789,:"

    fun parse(input: String): List<Int> {
        val customDelimiter = getCustomDelimiter(input)
        val numberSection = getNumberSection(input, customDelimiter)
        checkInputValid(numberSection)
        val strNumList = getStrNumList(numberSection, customDelimiter)
        return strNumList.map{ it.toIntOrNull() ?: 0 }
    }

    private fun getNumberSection( input: String, customDlmt: String?): String {
        if(customDlmt != null) return input.substringAfter("\\n")
        return input
    }

    private fun getStrNumList(input: String, customDelimiter: String?): List<String> {
        if(input.isEmpty()) return listOf("0")
        val delimiters = mutableListOf(",", ":")
        if (customDelimiter != null) delimiters += customDelimiter
        val strNumList = input.split(*delimiters.toTypedArray())
        return strNumList
    }

    private fun getCustomDelimiter(input: String) :String?{
        val customDelimiterRegex = Regex("""^//(.+?)\\n""")
        val match = customDelimiterRegex.find(input)
        val customDelimiter = match?.groupValues?.get(1)
        if(customDelimiter != null) validChars += customDelimiter
        return customDelimiter
    }

    private fun checkInputValid( input: String ): Boolean {
        if(input.all{it  in validChars }) return true
        else throw IllegalArgumentException("유효하지 않은 문자열 형식입니다. 프로그램을 종료합니다")

    }
}
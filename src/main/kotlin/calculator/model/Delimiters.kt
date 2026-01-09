package calculator.model

data class Delimiters(var delimiters: List<String>) {
    fun addDelimiter(delimiter: String) {
        if (delimiter != "")
            this.delimiters += delimiter
    }

    fun splitInput(input: String): List<String> {
        return input.split(*delimiters.toTypedArray())
    }

}


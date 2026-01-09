package calculator.model

import calculator.model.CalculatorConstants.BASIC_DELIMITERS

object Validator {
    fun validateCustomDelimiter(customDelimiter: String) {
        if (customDelimiter in BASIC_DELIMITERS) {
            throw IllegalArgumentException("[ERROR] 커스텀 구분자가 이미 구분자로 존재합니다.")
        }
    }

    fun validateNumberCandidate(candidate: List<String>) {
        candidate.forEach {
            it.toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] 잘못된 숫자입력입니다.")
        }
    }


}
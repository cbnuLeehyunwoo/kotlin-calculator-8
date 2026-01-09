package calculator.model

class Calculator() {
    fun add(calcPart: List<Int>): Int {
        return calcPart.map { it }.sumOf { it }
    }


}

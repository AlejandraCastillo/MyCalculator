package com.example.mycalculator

import androidx.compose.runtime.mutableStateListOf

class BasicMathProcessor : MathProcessor {
    val operators: MutableList<Char> = mutableListOf()
    val numbers: MutableList<Double> = mutableListOf()
    var error: Boolean = false

    override fun addOperator(operator: Char) {
        operators.add(operator)
    }

    override fun addNumber(number: Double) {
        numbers.add(number)
    }

    override fun clear() {
        operators.clear()
        numbers.clear()
    }

    override fun evaluate(): Double {
        do {
            val index = operators
                .indexOfFirst { it == 'X' || it == '/' }
            when(operators[index]){
                'X' -> {
                    val aux = numbers[index] * numbers[index + 1]
                    numbers[index] = aux
                    numbers.removeAt(index + 1)
                }
                '/' -> {
                    if(numbers[index + 1] != 0.0){
                        val aux = numbers[index] / numbers[index + 1]
                        numbers.removeAt(index)
                        numbers[index] = aux
                    }
                    else{
                        error = true
                        return 0.0
                    }
                }
            }
        }while(index != -1)

        operators.forEachIndexed{ i, value ->
            if(value == '-'){
                numbers[i+1] = -numbers[i+1]
            }
        }

        return numbers.sum()
    }

}
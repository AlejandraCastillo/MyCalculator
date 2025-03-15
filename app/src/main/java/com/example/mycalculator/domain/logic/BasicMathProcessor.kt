package com.example.mycalculator

class BasicMathProcessor : MathProcessor {

    private val TAG = "BasicMathProcessor"

    val operators: MutableList<Char> = mutableListOf()
    val numbers: MutableList<Double> = mutableListOf()
    private var _error: Boolean = false
    val error: Boolean
        get() = _error

    override fun addOperator(operator: Char) {
        if (operator == '+' || operator == '-'|| operator == '*'|| operator == '/'){
            operators.add(operator)
        }
    }

    override fun addNumber(number: Double) {
        if(_error) _error = false
        numbers.add(number)
    }

    override fun clear() {
        _error = false
        operators.clear()
        numbers.clear()
    }

    private fun itsAnError(): Double{
        clear()
        _error = true
        return 0.0
    }

    override fun evaluate(): Double {
        while(operators.any { it == '*' || it == '/' }){
            val index = operators
                .indexOfFirst { it == '*' || it == '/' }
            val operator = operators[index]
            operators.removeAt(index)
            when(operator){
                '*' -> {
                    val aux = numbers[index] * numbers[index + 1]
                    numbers[index] = aux
                    numbers.removeAt(index + 1)
                }
                '/' -> {
                    if(numbers[index + 1] != 0.0){
                        val aux = numbers[index] / numbers[index + 1]
                        numbers[index] = aux
                        numbers.removeAt(index + 1)
                    }
                    else{
                        return itsAnError()
                    }
                }
            }
        }

        operators.forEachIndexed{ i, value ->
            if(value == '-'){
                numbers[i+1] = -numbers[i+1]
            }
        }

        val result = numbers.sum()

        clear()
        addNumber(result)

        return result
    }

}
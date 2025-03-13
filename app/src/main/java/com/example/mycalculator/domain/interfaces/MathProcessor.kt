package com.example.mycalculator

interface MathProcessor {
    fun addOperator(operator: Char)
    fun addNumber(number: Double)
    fun clear()
    fun evaluate():Double
}
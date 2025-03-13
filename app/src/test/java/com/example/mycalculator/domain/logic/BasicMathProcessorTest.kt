package com.example.mycalculator.domain.logic

import com.example.mycalculator.BasicMathProcessor
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class BasicMathProcessorTest{
    private lateinit var mathProcessor: BasicMathProcessor //lateinti -> declarado, pero no inicializado

    @Before
    fun setUp(){
        mathProcessor = BasicMathProcessor()
    }

    @Test
    fun `addOperator should add valid operators to the list in correct order`(): Unit {
        // Act: llamamos al metdo a probar
        //agregamos operadores
        mathProcessor.addOperator('+')
        mathProcessor.addOperator('-')
        mathProcessor.addOperator('X')
        mathProcessor.addOperator('/')

        // Assert: comprobamos/verificamos
        //las listas tienen que ser iguales
        assertEquals(listOf('+', '-', 'X', '/'), mathProcessor.operators)
    }

    @Test
    fun `addOperator should not add invalid operators to the list`(): Unit {
        // Act: llamamos al metdo a probar
        //agregamos operadores
        mathProcessor.addOperator('x')
        mathProcessor.addOperator('#')
        mathProcessor.addOperator('b')
        mathProcessor.addOperator('&')

        // Assert: comprobamos/verificamos
        //la lista esta vacia

        //las listas tienen que ser iguales
        assertTrue("Expected an empty list, but was ${mathProcessor.operators}",
            mathProcessor.operators.isEmpty())
    }

    @Test
    fun `addNumber should add numbers to the list in correct order`(): Unit {
        //Act: agregamos números
        mathProcessor.addNumber(2.3)
        mathProcessor.addNumber(4.0)
        mathProcessor.addNumber(8.1)
        mathProcessor.addNumber(3.0)
        mathProcessor.addNumber(5.3)

        //Assert: la lista es correcta
        assertEquals(listOf(2.3, 4.0, 8.1, 3.0, 5.3), mathProcessor.numbers)
    }

    @Test
    fun `clear should set empty number list and operator list and set error flag in false`(): Unit{
        //Arrange(preparar)
        mathProcessor.addNumber(2.3)
        mathProcessor.addOperator('+')
        mathProcessor.error = true

        //Act
        mathProcessor.clear()

        //Assert
        assertTrue("Expected an empty list, but was ${mathProcessor.operators}",
            mathProcessor.operators.isEmpty())
        assertTrue("Expected an empty list, but was ${mathProcessor.numbers}",
            mathProcessor.numbers.isEmpty())
        assertTrue("Expected error flag to be false, but was true ",
                mathProcessor.error == false)
    }
}
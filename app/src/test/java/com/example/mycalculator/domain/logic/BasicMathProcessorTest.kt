package com.example.mycalculator.domain.logic

import com.example.mycalculator.BasicMathProcessor
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class BasicMathProcessorTest{
    private lateinit var mathProcessor: BasicMathProcessor //lateinti -> declarado, pero no inicializado
    private val delta = 0.00001

    @Before
    fun setUp(){
        mathProcessor = BasicMathProcessor()
    }

    @Test
    fun `addOperator should add valid operators to the list in correct order`() {
        // Act: llamamos al metdo a probar
        //agregamos operadores
        mathProcessor.addOperator('+')
        mathProcessor.addOperator('-')
        mathProcessor.addOperator('*')
        mathProcessor.addOperator('/')

        // Assert: comprobamos/verificamos
        //las listas tienen que ser iguales
        assertEquals(listOf('+', '-', '*', '/'), mathProcessor.operators)
    }

    @Test
    fun `addOperator should not add invalid operators to the list`() {
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
    fun `addNumber should add numbers to the list in correct order`() {
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
    fun `addNumber should set the error flag to false if it was true`() {
        //Arrange
        mathProcessor.addNumber(4.0)
        mathProcessor.addOperator('/')
        mathProcessor.addNumber(0.0)
        mathProcessor.evaluate() // get an error

        //Act
        mathProcessor.addNumber(4.0)

        //Assert
        assertTrue("Expected error flag to be false, but was ${mathProcessor.error}",
            mathProcessor.error == false)

    }

    @Test
    fun `clear should set empty numbers list and operators list and set error flag in false`() {
        //Arrange(preparar)
        mathProcessor.addNumber(4.0)
        mathProcessor.addOperator('/')
        mathProcessor.addNumber(0.0)
        mathProcessor.evaluate()
        mathProcessor.addNumber(2.3)
        mathProcessor.addOperator('+')

        //Act
        mathProcessor.clear()

        //Assert
        assertTrue("Expected an empty list, but was ${mathProcessor.operators}",
            mathProcessor.operators.isEmpty())
        assertTrue("Expected an empty list, but was ${mathProcessor.numbers}",
            mathProcessor.numbers.isEmpty())
        assertTrue("Expected error flag to be false, but was ${mathProcessor.error}",
            mathProcessor.error == false)
    }

    /* Operaciones simples */
    @Test
    fun `evaluate should perform basic addition correctly`() {
        //Arrange(preparar)
        mathProcessor.addNumber(2.5)
        mathProcessor.addOperator('+')
        mathProcessor.addNumber(2.5)

        //Act
        val result = mathProcessor.evaluate()

        //Assert
        assertEquals(5.0, result, delta)
    }

    @Test
    fun `evaluate should perform basic subtractions correctly`() {
        //Arrange(preparar)
        mathProcessor.addNumber(10.7)
        mathProcessor.addOperator('-')
        mathProcessor.addNumber(5.2)

        //Act
        val result = mathProcessor.evaluate()

        //Assert
        assertEquals(5.5, result, delta)
    }

    @Test
    fun `evaluate should perform basic multiplication correctly`() {
        //Arrange(preparar)
        mathProcessor.addNumber(3.1)
        mathProcessor.addOperator('*')
        mathProcessor.addNumber(4.2)

        //Act
        val result = mathProcessor.evaluate()

        //Assert
        assertEquals(13.02, result, delta)
    }

    @Test
    fun `evaluate should perform basic division correctly`() {
        //Arrange(preparar)
        mathProcessor.addNumber(8.4)
        mathProcessor.addOperator('/')
        mathProcessor.addNumber(2.0)

        //Act
        val result = mathProcessor.evaluate()

        //Assert
        assertEquals(4.2, result, delta)
    }

    /* jerarquia de operaciones */

    @Test
    fun `evaluate should perform multiplication and division before addition and subtraction`() {
        //Arrange
        mathProcessor.addNumber(6.0)
        mathProcessor.addOperator('+')
        mathProcessor.addNumber(3.0)
        mathProcessor.addOperator('*')
        mathProcessor.addNumber(2.0)
        mathProcessor.addOperator('-')
        mathProcessor.addNumber(4.0)
        mathProcessor.addOperator('/')
        mathProcessor.addNumber(2.0)

        //Act
        val result = mathProcessor.evaluate()

        //Assert
        assertEquals(10.0, result, delta)
    }

    @Test
    fun `evaluation should respect the order from left to right when the operations are in the same hierarchy`() {
        //Arrange
        mathProcessor.addNumber(8.0)
        mathProcessor.addOperator('/')
        mathProcessor.addNumber(2.0)
        mathProcessor.addOperator('*')
        mathProcessor.addNumber(3.0)

        //Act
        val result = mathProcessor.evaluate()


        //Assert
        assertEquals(12.0, result, delta)
    }

    @Test
    fun `evaluate should respect the hierarchy of operations`() {
        //Arrange
        mathProcessor.addNumber(6.0)
        mathProcessor.addOperator('+')
        mathProcessor.addNumber(3.0)
        mathProcessor.addOperator('*')
        mathProcessor.addNumber(2.0)
        mathProcessor.addOperator('/')
        mathProcessor.addNumber(4.0)
        mathProcessor.addOperator('-')
        mathProcessor.addNumber(2.0)

        //Act
        val result = mathProcessor.evaluate()


        //Assert
        assertEquals(5.5, result, delta)
    }

    /* Dividir entre 0 */
    @Test
    fun `evaluate should give an error when dividing by zero`() {
        //Arrange
        mathProcessor.addNumber(4.0)
        mathProcessor.addOperator('/')
        mathProcessor.addNumber(0.0)

        //Act
        mathProcessor.evaluate()

        //Assert
        assertTrue("Expected error flag to be true, but was ${mathProcessor.error}",
            mathProcessor.error == true)

    }

    @Test
    fun `when theres an error numbers list and operators list must be emptied`(){
        //Arrange
        mathProcessor.addNumber(4.0)
        mathProcessor.addOperator('/')
        mathProcessor.addNumber(0.0)

        //Act
        mathProcessor.evaluate() // get an error

        //Assert
        assertTrue("Expected an empty list, but was ${mathProcessor.operators}",
            mathProcessor.operators.isEmpty())
        assertTrue("Expected an empty list, but was ${mathProcessor.numbers}",
            mathProcessor.numbers.isEmpty())
    }




}
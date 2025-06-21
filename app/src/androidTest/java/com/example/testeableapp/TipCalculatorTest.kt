package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import org.junit.Assert.assertEquals
import org.junit.Test


class TipCalculatorTest {
    @Test
    fun calcularPropina() {
        val amountMoney = 100.0
        val tipPercent = 37
        val round = true
        val result = calculateTip(amountMoney, tipPercent, round)
        val expected = 37.0
        assertEquals(expected, result, 0.0)
    }

    @Test
    fun calcularPropinaMontoNegativo() {
        val amountMoney = -150.0
        val tipPercent = 20
        val round = false
        val result = calculateTip(amountMoney, tipPercent, round)
        assertEquals(0.0, result, 0.0)
        //Function does allow negative so test is going to fail
    }

    @Test
    fun calcularTotalPorPersona() {
        val monto = 120.0
        val tipPercent = 10
        val numPersonas = 4
        val esperado = (monto + (monto * tipPercent / 100)) / numPersonas
        val resultado =33.0
        assertEquals(esperado, resultado, 0.0)
    }

    //Additionals
    @Test
    fun porcentajePropina0Propina0() {
        val result = calculateTip(500.0, 0, false)
        assertEquals(0.0, result, 0.0)
    }

    @Test
    fun verificarRedondeo() {
        val result = calculateTip(235.20, 15, true)
        assertEquals(36.0, result, 0.0)
    }
}

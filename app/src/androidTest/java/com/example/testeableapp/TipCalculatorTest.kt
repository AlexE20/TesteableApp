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
        val expected = kotlin.math.ceil(amountMoney * tipPercent / 100)
        assertEquals(expected, result, 0.0)
    }

    @Test
    fun calcularPropinaMontoNegativo() {
        val amountMoney = -20.0
        val tipPercent = 20
        val round = false
        val result = calculateTip(amountMoney, tipPercent, round)
        assertEquals(0.0, result, 0.0)
    }

    private fun calcularTotalPorPersona(monto: Double, tipPercent: Int, numPersonas: Int, roundUp: Boolean): Double {
        val tip = calculateTip(monto, tipPercent, roundUp)
        return if (numPersonas > 0) (monto + tip) / numPersonas else 0.0
    }

    @Test
    fun calcularTotalPorPersona() {
        val monto = 120.0
        val tipPercent = 10
        val numPersonas = 3
        val roundUp = false
        val esperado = (monto + (monto * tipPercent / 100)) / numPersonas
        val resultado = calcularTotalPorPersona(monto, tipPercent, numPersonas, roundUp)
        assertEquals(esperado, resultado, 0.0)
    }

    //Additionals
    @Test
    fun porcentajePropina0Propina0() {
        val result = calculateTip(500.0, 0, false)
        assertEquals(0.0, result, 0.0)
    }
}
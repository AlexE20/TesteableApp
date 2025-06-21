package com.example.testeableapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.performSemanticsAction
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onChild

class UI {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
            fun redondearPropinaValidarCambio() {
        composeTestRule.setContent { TipCalculatorScreen() }

        composeTestRule.onNodeWithTag("billAmount").performTextInput("110.58")
        composeTestRule.onNodeWithTag("tipPercent")
            .performSemanticsAction(SemanticsActions.SetProgress) { it(37f) }
        composeTestRule.onNodeWithTag("roundUp").performClick()
        composeTestRule.onNodeWithText("Propina: $41.00").assertExists()
    }

    @Test
    fun validarSlider() {
        composeTestRule.setContent { TipCalculatorScreen() }

        composeTestRule.onNodeWithTag("billAmount").performTextInput("400")
        composeTestRule.onNodeWithTag("tipPercent")
            .performSemanticsAction(SemanticsActions.SetProgress) { it(20f) }
        composeTestRule.onNodeWithTag("roundUp").performClick()
        composeTestRule.onNodeWithText("Propina: $80.00").assertExists()
    }

    @Test
    fun elementosVisibles() {
        composeTestRule.setContent { TipCalculatorScreen() }
        composeTestRule.onNodeWithTag("billAmount").assertExists()
        composeTestRule.onNodeWithTag("tipPercent").assertExists()
        composeTestRule.onNodeWithTag("peopleRow").assertExists()
    }

    //Additional
    @Test
    fun validarCambioNumeroPersonas() {
        composeTestRule.setContent { TipCalculatorScreen() }

        composeTestRule.onNodeWithTag("billAmount").performTextInput("200")
        composeTestRule.onNodeWithTag("tipPercent")
            .performSemanticsAction(SemanticsActions.SetProgress) { it(15f) }
        composeTestRule.onNodeWithTag("increasePeople").performClick()
        composeTestRule.onNodeWithTag("peopleRow").assertTextEquals("Número de personas: 2")
    }

    @Test
    fun validarCambioNumeroPersonas2Clicks() {
        composeTestRule.setContent { TipCalculatorScreen() }

        composeTestRule.onNodeWithTag("billAmount").performTextInput("1234")
        composeTestRule.onNodeWithTag("tipPercent")
            .performSemanticsAction(SemanticsActions.SetProgress) { it(14f) }
        composeTestRule.onNodeWithTag("increasePeople").performClick().performClick()
        composeTestRule.onNodeWithText("Total por persona: $468.92").assertExists()
    }


}
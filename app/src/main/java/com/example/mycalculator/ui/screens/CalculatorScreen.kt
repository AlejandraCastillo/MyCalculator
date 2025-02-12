package com.example.mycalculator.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycalculator.ui.components.ButtonPanel
import com.example.mycalculator.ui.components.DisplayPanel

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {
    var mainDisplayText by remember { mutableStateOf("") }
    var secondaryDisplayText by remember { mutableStateOf("") }


    Box(modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            DisplayPanel(mainDisplayText, secondaryDisplayText)
            ButtonPanel(
                mainDisplayText = mainDisplayText,
                secondaryDisplayText = secondaryDisplayText,
                updateMainDisplay = { newText -> mainDisplayText = newText },
                updateSecondaryDisplay = { newText -> secondaryDisplayText = newText },
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevCalculatorScreen() {
    Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding ->
        CalculatorScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}
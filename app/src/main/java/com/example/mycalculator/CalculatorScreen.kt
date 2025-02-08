package com.example.mycalculator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycalculator.ui.theme.MyCalculatorTheme

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {

    Box(modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            DisplayPanel("3", "2 + 1")
            ButtonPanel(
                Modifier.padding(vertical = 8.dp)
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
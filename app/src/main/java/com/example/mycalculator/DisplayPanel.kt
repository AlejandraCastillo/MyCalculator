package com.example.mycalculator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun DisplayPanel(
    mainText: String,
    secondaryText: String,
    modifier: Modifier = Modifier
) {
    Box (
        modifier.fillMaxWidth()
    ) {
        Column (
            horizontalAlignment = Alignment.End,
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            SecondaryDisplay("2")
            MainDisplay("1")
        }
    }
}
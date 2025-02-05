package com.example.mycalculator

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun SecondaryDisplay(
    secondaryText: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = secondaryText,
        style = TextStyle(
            fontSize = 52.sp,
            color = Color.LightGray,
        ),
        textAlign = TextAlign.End
    )
}
package com.example.mycalculator

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun MainDisplay(
    mainText: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = mainText,
        style = TextStyle(
            fontSize = 68.sp
        ),
        minLines = 1,
        maxLines = 1,
        softWrap = false,
        textAlign = TextAlign.End,
    )
}


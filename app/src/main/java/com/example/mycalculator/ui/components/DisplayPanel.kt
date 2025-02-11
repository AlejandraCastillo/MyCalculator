package com.example.mycalculator.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

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
            SecondaryDisplay(secondaryText)
            MainDisplay(mainText)
        }
    }
}
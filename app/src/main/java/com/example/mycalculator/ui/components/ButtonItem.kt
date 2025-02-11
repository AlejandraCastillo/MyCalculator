package com.example.mycalculator.ui.`components `

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.data.ButtonKind

@Composable
fun ButtonItem(
    content: String,
    buttonKind: ButtonKind,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor =
            when (buttonKind) {
                ButtonKind.Number -> MaterialTheme.colorScheme.surface
                ButtonKind.Operation -> MaterialTheme.colorScheme.primary
                is ButtonKind.Action -> {
                    if(buttonKind == ButtonKind.Action.Result)
                        MaterialTheme.colorScheme.primary
                    else
                        MaterialTheme.colorScheme.secondary
                }
            },
            contentColor =
            when (buttonKind) {
                ButtonKind.Number -> MaterialTheme.colorScheme.onSurface
                ButtonKind.Operation -> MaterialTheme.colorScheme.onPrimary
                is ButtonKind.Action -> {
                    if(buttonKind == ButtonKind.Action.Result)
                        MaterialTheme.colorScheme.onPrimary
                    else
                        MaterialTheme.colorScheme.onSecondary
                }
            }
        ),
        modifier = modifier
    ) {
        Text(
            text = content,
            style = TextStyle(
                fontSize = 25.sp
            ),
            softWrap = false,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(0.8f)
        )
    }
}

@Preview
@Composable
private fun PrevCalculatorButton1() {
    ButtonItem(
        content = "AC",
        buttonKind = ButtonKind.Action.AC,
        modifier = Modifier.size(80.dp)
    )
}
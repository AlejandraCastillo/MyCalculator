package com.example.mycalculator

data class ButtonDetails(
    val content: String,
    val buttonKind: ButtonKind = ButtonKind.Number,
)
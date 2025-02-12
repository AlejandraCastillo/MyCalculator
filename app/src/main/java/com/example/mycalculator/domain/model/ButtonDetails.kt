package com.example.mycalculator.domain.model

data class ButtonDetails(
    val content: String,
    val buttonKind: ButtonKind = ButtonKind.Number,
)
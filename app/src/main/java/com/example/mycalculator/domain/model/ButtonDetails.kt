package com.example.mycalculator.data

import com.example.mycalculator.domain.model.ButtonKind

data class ButtonDetails(
    val content: String,
    val buttonKind: ButtonKind = ButtonKind.Number,
)
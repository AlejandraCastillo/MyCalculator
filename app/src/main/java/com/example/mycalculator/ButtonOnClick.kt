package com.example.mycalculator

interface ButtonOnClick {
    fun onClick(
        buttonContent: String,
        mainDisplayText: String,
        secondaryDisplayText: String,
        updateMainDisplay: (String) -> Unit,
        updateSecondaryDisplay: (String) -> Unit,
    )
}
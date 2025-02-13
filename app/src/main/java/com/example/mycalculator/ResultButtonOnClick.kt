package com.example.mycalculator

class ResultButtonOnClick : ButtonOnClick {
    override fun onClick(
        buttonContent: String,
        mainDisplayText: String,
        secondaryDisplayText: String,
        updateMainDisplay: (String) -> Unit,
        updateSecondaryDisplay: (String) -> Unit,
    ) {
        updateMainDisplay(mainDisplayText + buttonContent)
        updateSecondaryDisplay(secondaryDisplayText + buttonContent)
    }
}
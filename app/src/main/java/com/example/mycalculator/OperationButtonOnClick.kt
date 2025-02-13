package com.example.mycalculator

class OperationButtonOnClick : ButtonOnClick {
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
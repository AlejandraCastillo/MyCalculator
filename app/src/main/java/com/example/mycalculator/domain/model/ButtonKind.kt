package com.example.mycalculator.domain.model

import com.example.mycalculator.AllClearButtonOnClick
import com.example.mycalculator.ButtonOnClick
import com.example.mycalculator.EraseButtonOnClick
import com.example.mycalculator.NumberButtonOnClick
import com.example.mycalculator.OperationButtonOnClick
import com.example.mycalculator.PercentButtonOnClick
import com.example.mycalculator.ResultButtonOnClick

sealed class ButtonKind (val buttonOnClick: ButtonOnClick) {
    object Number : ButtonKind(NumberButtonOnClick()) // Surface
    object Operation : ButtonKind(OperationButtonOnClick()) //Primary
    sealed class Action(val buttonAction: ButtonOnClick) : ButtonKind(buttonAction) {  //Secondary
        object AC : Action(AllClearButtonOnClick())
        object Erase : Action(EraseButtonOnClick())
        object Percent : Action(PercentButtonOnClick())
        object Result : Action(ResultButtonOnClick()) // Primary
    }
}

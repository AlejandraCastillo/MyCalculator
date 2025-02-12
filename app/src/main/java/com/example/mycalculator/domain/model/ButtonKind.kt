package com.example.mycalculator.domain.model

import com.example.mycalculator.ButtonOnClick
import com.example.mycalculator.NumberButtonOnClick

sealed class ButtonKind (val buttonAction: ButtonOnClick) {
    object Number : ButtonKind(NumberButtonOnClick()) // Surface
    object Operation : ButtonKind(NumberButtonOnClick()) //Primary
    sealed class Action : ButtonKind(NumberButtonOnClick()) {  //Secondary
        object AC : Action()
        object Erase : Action()
        object Percent : Action()
        object Result : Action() //Primary
    }
}

package com.example.mycalculator.domain.model

sealed class ButtonKind {
    object Number : ButtonKind() // Surface
    object Operation : ButtonKind() //Primary
    sealed class Action : ButtonKind() {  //Secondary
        object AC : Action()
        object Erase : Action()
        object Percent : Action()
        object Result : Action() //Primary
    }
}

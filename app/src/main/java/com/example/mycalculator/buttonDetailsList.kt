package com.example.mycalculator

val buttonDetailsList: List<ButtonDetails> = listOf(
    ButtonDetails("AC", ButtonKind.Action.AC),
    ButtonDetails("⌫", ButtonKind.Action.Erase),
    ButtonDetails("%", ButtonKind.Action.Percent),
    ButtonDetails("/", ButtonKind.Operation),
    ButtonDetails("7"),
    ButtonDetails("8"),
    ButtonDetails("9"),
    ButtonDetails("X", ButtonKind.Operation),
    ButtonDetails("4"),
    ButtonDetails("5"),
    ButtonDetails("6"),
    ButtonDetails("-", ButtonKind.Operation),
    ButtonDetails("1"),
    ButtonDetails("2"),
    ButtonDetails("3"),
    ButtonDetails("+", ButtonKind.Operation),
    ButtonDetails("0"),
    ButtonDetails("."),
    ButtonDetails("=", ButtonKind.Action.Result),
)
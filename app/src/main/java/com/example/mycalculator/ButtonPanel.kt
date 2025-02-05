package com.example.mycalculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid as LazyVerticalGrid1

@Composable
fun ButtonPanel(modifier: Modifier = Modifier) {
    LazyVerticalGrid1(
        columns = GridCells.Fixed(4),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        userScrollEnabled = false,
        modifier = modifier,
    ) {
        items(
            items = buttonDetailsList,
            span = { item ->
                if (item.content == "0") {
                    GridItemSpan(2)
                } else {
                    GridItemSpan(1)
                }
            }
        ) { item ->
            ButtonItem(
                buttonKind = item.buttonKind,
                content = item.content
            )
        }
    }
}


@Preview
@Composable
private fun PrevButtonPanel() {
    ButtonPanel(
        modifier = Modifier
    )
}
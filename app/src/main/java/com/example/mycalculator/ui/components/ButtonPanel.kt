package com.example.mycalculator.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycalculator.domain.model.buttonDetailsList
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid as LazyVerticalGrid1

@Composable
fun ButtonPanel(
    mainDisplayText: String,
    secondaryDisplayText: String,
    updateMainDisplay: (String) -> Unit,
    updateSecondaryDisplay: (String) -> Unit,
    modifier: Modifier = Modifier) {
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
                content = item.content,
                onClick = {
                    item.buttonKind.buttonOnClick.onClick(
                        item.content,
                        mainDisplayText,
                        secondaryDisplayText,
                        updateMainDisplay,
                        updateSecondaryDisplay
                    )
                }
            )
        }
    }
}



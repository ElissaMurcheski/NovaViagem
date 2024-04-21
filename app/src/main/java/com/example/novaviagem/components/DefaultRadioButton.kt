package com.example.novaviagem.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun RowScope.DefaultRadioButton(value: Boolean) {
    val selected = remember { mutableStateOf(value) }
    RadioButton(
        selected = selected.value,
        onClick = { selected.value = !selected.value },
        modifier = Modifier
            .weight(0.5f)
    )
}
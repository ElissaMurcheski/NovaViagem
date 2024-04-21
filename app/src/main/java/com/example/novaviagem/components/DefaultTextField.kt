package com.example.novaviagem.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource


@Composable
fun RowScope.DefaultTextField(value: String, @StringRes label: Int) {
    val textValue = remember { mutableStateOf(value) }
    OutlinedTextField(
        value = textValue.value,
        label = { Text(stringResource(label)) },
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { textValue.value = it }
    )
}



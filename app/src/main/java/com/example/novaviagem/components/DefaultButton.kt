package com.example.novaviagem.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun RowScope.DefaultButton(text: String) {
    Button(
        onClick = { },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text, fontSize = 20.sp)
    }
}
package com.example.novaviagem.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RowScope.DefaultDateField(value: String, @StringRes label: Int) {
    val showDatePickerDialog = remember {
        mutableStateOf(false)
    }
    val selectedDate = remember {
        mutableStateOf(value)
    }
    val datePickerState = rememberDatePickerState()

    if (showDatePickerDialog.value) {
        DatePickerDialog(
            onDismissRequest = { showDatePickerDialog.value = false },
            confirmButton = {
                Button(
                    onClick = {
                        datePickerState.selectedDateMillis?.let { millis ->
                            selectedDate.value = millis.toBrazilianDateFormat()
                        }
                        showDatePickerDialog.value = false
                    }) {
                    Text(text = "Escolher data")
                }
            },
            modifier = Modifier
        ) {
            DatePicker(state = datePickerState)
        }
    }

    OutlinedTextField(
        value = selectedDate.value,
        label = { Text(stringResource(label)) },
        onValueChange = { },
        modifier = Modifier
            .onFocusChanged { if (it.isFocused) showDatePickerDialog.value = true }
            .fillMaxWidth(),
        readOnly = true
    )
}

fun Long.toBrazilianDateFormat(
    pattern: String = "dd/MM/yyyy"
): String {
    val date = Date(this)
    val formatter = SimpleDateFormat(
        pattern, Locale("pt-br")
    ).apply {
        timeZone = TimeZone.getTimeZone("GMT")
    }
    return formatter.format(date)
}
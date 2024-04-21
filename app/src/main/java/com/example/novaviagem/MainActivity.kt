package com.example.novaviagem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.novaviagem.components.DefaultButton
import com.example.novaviagem.components.DefaultDateField
import com.example.novaviagem.components.DefaultLabel
import com.example.novaviagem.components.DefaultNumberField
import com.example.novaviagem.components.DefaultRadioButton
import com.example.novaviagem.components.DefaultTextField
import com.example.novaviagem.components.TopBar
import com.example.novaviagem.enums.TripType
import com.example.novaviagem.ui.theme.NovaViagemTheme
import com.example.novaviagem.viewModels.TripViewModal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NovaViagemTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    Scaffold(topBar = {
        TopBar()
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {
            Content()
        }
    }
}

@Composable
private fun Content(tripViewModal: TripViewModal = viewModel()) {
    val tipState = tripViewModal.uiState.collectAsState()

    Row(verticalAlignment = Alignment.CenterVertically) {
        DefaultTextField(tipState.value.destination, R.string.destination)
    }
    Spacer(modifier = Modifier.height(20.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
        DefaultLabel(R.string.tripType)
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        DefaultRadioButton(tipState.value.tripType == TripType.LEISURE.toString())
        DefaultLabel(R.string.leisure)
        DefaultRadioButton(tipState.value.tripType == TripType.BUSINESS.toString())
        DefaultLabel(R.string.business)
    }
    Spacer(modifier = Modifier.height(20.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
        DefaultDateField(tipState.value.startDate, R.string.startDate)
    }
    Spacer(modifier = Modifier.height(20.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
        DefaultDateField(tipState.value.endDate, R.string.endDate)
    }
    Spacer(modifier = Modifier.height(20.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
        DefaultNumberField(tipState.value.value.toString(), R.string.tripValue)
    }
    Spacer(modifier = Modifier.height(20.dp))
    Row(verticalAlignment = Alignment.CenterVertically) {
        DefaultButton("Salvar")
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    NovaViagemTheme {
        MyApp()
    }
}
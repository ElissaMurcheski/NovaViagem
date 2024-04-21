package com.example.novaviagem.viewModels

import androidx.lifecycle.ViewModel
import com.example.novaviagem.enums.TripType
import com.example.novaviagem.models.Trip
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TripViewModal : ViewModel() {
    private val _uiState = MutableStateFlow(Trip())
    val uiState: StateFlow<Trip> = _uiState.asStateFlow();

    fun updateDestination(newDestination: String) {
        _uiState.update {
            it.copy(destination = newDestination)
        }
    }

    fun updateTripType(newTripType: TripType) {
        _uiState.update {
            it.copy(tripType = newTripType.name)
        }
    }

    fun updateStartDate(newStartDate: String) {
        _uiState.update {
            it.copy(startDate = newStartDate)
        }
    }

    fun updateEndDate(newEndDate: String) {
        _uiState.update {
            it.copy(endDate = newEndDate)
        }
    }

    fun updateValue(newValue: Float) {
        _uiState.update {
            it.copy(value = newValue)
        }
    }
}
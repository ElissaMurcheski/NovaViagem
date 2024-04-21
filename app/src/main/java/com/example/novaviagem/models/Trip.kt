package com.example.novaviagem.models

import com.example.novaviagem.enums.TripType

data class Trip(
    val destination: String = "EUA",
    val tripType: String = TripType.LEISURE.toString(),
    val startDate: String = "",
    val endDate: String = "",
    val value: Float = 0.0f
)
package com.example.measureunitconvertergk.util

fun assignConversionFromText(selectedConversionType: String): String {
        return when (selectedConversionType) {
                "km <--> mile" -> "Kilometers"
                "km <--> feet" -> "Kilometers"
                "m <--> mile" -> "Meters"
                "m <--> feet" -> "Meters"
                else -> "Unknown selection"
        }
}

fun assignConversionToText(selectedConversionType: String): String {
        return when (selectedConversionType) {
                "km <--> mile" -> "Miles"
                "km <--> feet" -> "Feet"
                "m <--> mile" -> "Miles"
                "m <--> feet" -> "Feet"
                else -> "Unknown selection"
        }
}

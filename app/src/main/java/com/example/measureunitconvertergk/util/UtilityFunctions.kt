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

fun convert(value: Double, conversionType: String): String {
        return when (conversionType) {
                "km <--> mile" -> (value * 0.621371).toString()
                "km <--> feet" -> (value * 3280.84).toString()
                "m <--> mile" -> (value * 0.000621371).toString()
                "m <--> feet" -> (value * 3.28084).toString()
                else -> "Invalid Conversion Type"
        }
}
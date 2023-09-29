package com.example.measureunitconvertergk.viewmodels

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.measureunitconvertergk.R
import com.example.measureunitconvertergk.util.assignConversionFromText
import com.example.measureunitconvertergk.util.assignConversionToText

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val conversionTypes: List<String> = listOf(
        R.string.km_mile,
        R.string.km_feet,
        R.string.m_mile,
        R.string.m_feet
    ).map { getApplication<Application>().getString(it) }

    var selectedIndex by mutableStateOf(0)

    var result by mutableStateOf(0.0)

    var conversionFrom by mutableStateOf(assignConversionFromText(conversionTypes[0]))

    var conversionTo by mutableStateOf(assignConversionToText(conversionTypes[0]))

    private val _selectedOption = mutableStateOf(conversionTypes[0])
    val selectedOption: State<String> = _selectedOption

    fun onOptionSelected(index: Int) {
        selectedIndex = index
        _selectedOption.value = conversionTypes[index]
        conversionFrom = assignConversionFromText(selectedOption.value)
        conversionTo = assignConversionToText(selectedOption.value)
        result = 0.0
    }
}
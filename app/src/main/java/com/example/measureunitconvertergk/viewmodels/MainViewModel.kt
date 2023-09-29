package com.example.measureunitconvertergk.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.measureunitconvertergk.R

class MainViewModel : ViewModel() {

    val items = listOf(
        R.string.km_mile,
        R.string.km_feet,
        R.string.m_mile,
        R.string.m_feet
    )

    var selectedIndex by mutableStateOf(0)

    private val _selectedOption = mutableStateOf(items[0])
    val selectedOption: State<Int> = _selectedOption

    fun onOptionSelected(index: Int) {
        _selectedOption.value = items[index]
        selectedIndex = index
    }
}
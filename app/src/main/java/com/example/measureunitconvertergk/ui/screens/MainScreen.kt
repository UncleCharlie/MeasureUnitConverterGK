package com.example.measureunitconvertergk.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.example.measureunitconvertergk.ui.components.MeasurementUnitDropdown
import com.example.measureunitconvertergk.ui.components.UserInputForm
import com.example.measureunitconvertergk.viewmodels.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val selectedOption by viewModel.selectedOption
    Column {
        Text(text = "Please select which units you would like to interchange:")
        MeasurementUnitDropdown(viewModel)
        UserInputForm(measurementUnit = stringResource(id = selectedOption))
    }
}
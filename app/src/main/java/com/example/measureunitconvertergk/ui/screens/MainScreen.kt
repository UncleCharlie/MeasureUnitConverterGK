package com.example.measureunitconvertergk.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.measureunitconvertergk.ui.components.MeasurementUnitDropdown
import com.example.measureunitconvertergk.ui.components.UserInputForm
import com.example.measureunitconvertergk.viewmodels.MainViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {
    val result = viewModel.result
    val conversionToText = viewModel.conversionTo
    Column ( modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {

        Scaffold(
            topBar = {
                Text(text = "Please select which units you would like to interchange:")
            }
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                MeasurementUnitDropdown(viewModel)
                UserInputForm(viewModel)
                Text(text = "The converted value is:$result $conversionToText")
            }
        }
    }
}
package com.example.measureunitconvertergk.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.measureunitconvertergk.util.convert
import com.example.measureunitconvertergk.viewmodels.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInputForm(viewModel: MainViewModel) {
    var textResult by rememberSaveable {
        mutableStateOf("")
    }
    var inputErrorState by rememberSaveable {
        mutableStateOf(false)
    }
    var inputValue by rememberSaveable {
        mutableStateOf("")
    }

    var conversionFromText = viewModel.conversionFrom


    fun validate(text: String) {
        val allDigit = text.all { char -> char.isDigit() }

        inputErrorState = !allDigit && text != ""
        if (inputErrorState) {
            textResult = "This field can be number only"
        }
    }

    Column {
        OutlinedTextField(
            label = { Text(text = "$conversionFromText:") },
            value = inputValue,
            onValueChange = {
                inputValue = it
                validate(inputValue)
            },
            isError = inputErrorState,
            trailingIcon = {
                if (inputErrorState)
                    Icon(
                        Icons.Filled.Warning,
                        "error", tint = MaterialTheme.colorScheme.error
                    )
            }
        )

        Button(onClick = {
            try {
                viewModel.result = convert(inputValue.toDouble(), viewModel.conversionTypes[viewModel.selectedIndex]).toDouble()
            } catch (e: Exception) {
                Log.e("ERROR","Error: ${e.message}")
            }
        }) {
            Text(text = "Convert")
        }
    }
}


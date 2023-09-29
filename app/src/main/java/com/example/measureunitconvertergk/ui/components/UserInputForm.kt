package com.example.measureunitconvertergk.ui.components

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
import androidx.compose.ui.unit.sp
import com.example.measureunitconvertergk.util.assignConversionFromText
import com.example.measureunitconvertergk.util.assignConversionToText
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInputForm(measurementUnit: String) {
    var randomNumber by rememberSaveable {
        mutableStateOf(Random(System.currentTimeMillis()).nextInt(3))
    }
    var conversionFromText by rememberSaveable {
        mutableStateOf(assignConversionFromText(measurementUnit))
    }
    var conversionToText by rememberSaveable {
        mutableStateOf(assignConversionToText(measurementUnit))
    }
    var textResult by rememberSaveable {
        mutableStateOf("")
    }
    var inputErrorState by rememberSaveable {
        mutableStateOf(false)
    }
    var showWinDialog by rememberSaveable {
        mutableStateOf(false)
    }


    fun validate(text: String) {
        val allDigit = text.all { char -> char.isDigit() }

        inputErrorState = !allDigit && text != ""
        if (inputErrorState) {
            textResult = "This field can be number only"
        }
    }
    Column {


        Text(text = "From:")

        OutlinedTextField(
            label = { Text(text = "Enter your guess here") },
            value = "$conversionFromText",
            onValueChange = {
                conversionFromText = it
                validate(conversionFromText)
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
                val myNumber = conversionFromText.toInt()
                if (myNumber == randomNumber) {
                    textResult = "You won"
                    showWinDialog = true
                } else {
                    textResult = "You lose"
                }
            } catch (e: Exception) {
                textResult = "Error: ${e.message}"
            }
        }) {
            Text(text = "Convert")
        }





        Text(text = "$textResult", fontSize = 28.sp)
    }
}


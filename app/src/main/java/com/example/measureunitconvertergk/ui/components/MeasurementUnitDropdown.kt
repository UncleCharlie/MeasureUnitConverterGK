package com.example.measureunitconvertergk.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.measureunitconvertergk.viewmodels.MainViewModel

@Composable
fun MeasurementUnitDropdown(viewModel: MainViewModel) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth() // Ensure that the Box fills up the maximum width available
            .padding(16.dp)
            .border(2.dp, Color.Gray)
            .height(50.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true })
                .background(MaterialTheme.colorScheme.background)
                .padding(8.dp), // Padding to Text for more prominence
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = viewModel.selectedOption)
            Icon(
                imageVector = Icons.Default.ArrowDropDown, // Dropdown indicator icon
                contentDescription = "Dropdown Indicator"
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            viewModel.conversionTypes.forEachIndexed { index, id ->
                DropdownMenuItem(
                    text = { Text(text = id) },
                    onClick = {
                        viewModel.onOptionSelected(index)
                        expanded = false
                    }
                )
            }
        }
    }
}

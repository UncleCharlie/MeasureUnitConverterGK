package com.example.measureunitconvertergk.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.measureunitconvertergk.util.assignConversionFromText
import com.example.measureunitconvertergk.viewmodels.MainViewModel

@Composable
fun MeasurementUnitDropdown(viewModel: MainViewModel) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .wrapContentSize(Alignment.TopStart)
            .size(height = 30.dp, width = 290.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = viewModel.selectedOption.value,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true })
                .background(MaterialTheme.colorScheme.background)
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    50.dp,50.dp
                )
                .background(MaterialTheme.colorScheme.surface)
        ) {
            viewModel.conversionTypes.forEachIndexed { index, id ->
                DropdownMenuItem(
                    text = { Text(text = id)},
                    onClick = {
                        viewModel.onOptionSelected(index)
                        expanded = false
                    }
                )
            }
        }
    }
}
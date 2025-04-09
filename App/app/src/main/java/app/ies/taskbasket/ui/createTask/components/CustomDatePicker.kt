package app.ies.taskbasket.ui.createTask.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.ies.taskbasket.utils.DateConverter
import java.time.Year

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(
    initialDate: Long,
    onDateSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val currentYear = Year.now().value
    val datePickerState = rememberDatePickerState(
        selectableDates = object: SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis >= System.currentTimeMillis()
            }
        },
        initialSelectedDateMillis = initialDate,
        yearRange = currentYear..currentYear+10
    )

    val selectedDate = datePickerState.selectedDateMillis?.let {
        DateConverter.millisToDate(it)
    } ?: ""

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = {
                    onDateSelected(selectedDate)
                    onDismiss()
                }
            ) {
                Text(text = "Okay", modifier = Modifier.padding(end = 10.dp))
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text(text = "Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomDatePickerPreview(){
    CustomDatePicker(System.currentTimeMillis(), {  }) { }
}
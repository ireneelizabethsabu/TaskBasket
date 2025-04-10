package app.ies.taskbasket.ui.createTask

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.ies.taskbasket.ui.common.AppScaffold
import app.ies.taskbasket.ui.common.ThemedElevatedButton
import app.ies.taskbasket.ui.common.ThemedFilterChip
import app.ies.taskbasket.ui.common.ThemedIconButton
import app.ies.taskbasket.ui.common.ThemedTextField
import app.ies.taskbasket.ui.common.ThemedTopBar
import app.ies.taskbasket.ui.createTask.components.CustomDatePicker
import app.ies.taskbasket.utils.DateConverter
import app.ies.taskbasket.utils.UiState
import app.ies.taskbasket.utils.model.Priority


@Composable
fun CreateTaskScreen(
    navigateToTaskScreen: () -> Unit,
    viewModel: CreateTaskViewModel = hiltViewModel()
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when(uiState.state){
        is UiState.Success -> { navigateToTaskScreen() }
        is UiState.Error -> {}
        is UiState.Loading -> {}
        is UiState.Idle -> {}
    }

    AppScaffold(
        topBar = {
            ThemedTopBar(
                isBackButtonPresent = true,
                onBackButtonClicked = {
                    navigateToTaskScreen()
                }
            )
        }
    ) {
        Column {
            Text(text = "Task", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Light)
            ThemedTextField(value = uiState.title, maxLines = 2 ) {
                viewModel.onTitleChange(it)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Description", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Light)
            ThemedTextField(value = uiState.description, maxLines = 5) {
                viewModel.onDescriptionChange(it)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Due date", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Light)
            Surface(
                shape = CircleShape,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .height(50.dp)
            ) {
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                        .clickable {
                            viewModel.onShowDialogChanged(true)
                        }
                ){
                    Text(
                        text = uiState.selectedDate.ifEmpty { "Select Date" },
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    ThemedIconButton(icon = Icons.Default.DateRange, onClick = {
                        viewModel.onShowDialogChanged(true)
                    })
                }
            }
            if(uiState.showDatePicker){
                CustomDatePicker(
                    initialDate = DateConverter.convertDateToMillis(uiState.selectedDate),
                    onDateSelected = { viewModel.onSelectedDateChanged(it)},
                    onDismiss = { viewModel.onShowDialogChanged(false) }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Priority", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Light)
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                Priority.entries.forEach {
                    ThemedFilterChip(isSelected = it == uiState.priority, item = it, isLarge = true) {
                        newPriority ->
                        viewModel.onPriorityChanged(newPriority)
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Members", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.weight(1f))
            ThemedElevatedButton(text = "Create Task") {
                viewModel.createTask()
            }
        }
    }
}



@Preview
@Composable
fun CreateTaskScreenPreview(){
    CreateTaskScreen(
        navigateToTaskScreen = {},
    )
}
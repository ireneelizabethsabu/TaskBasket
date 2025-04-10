package app.ies.taskbasket.ui.task

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import app.ies.taskbasket.ui.common.AppScaffold
import app.ies.taskbasket.ui.common.CircleAvatarWithBackground
import app.ies.taskbasket.ui.common.ThemedIconButton
import app.ies.taskbasket.ui.common.ThemedTopBar
import app.ies.taskbasket.ui.task.components.TaskOverviewCard
import app.ies.taskbasket.ui.task.components.TaskStatusCard

@Composable
fun TaskScreen(
    navigateToCreateTaskScreen: () -> Unit,
    viewModel: TaskScreenViewModel = hiltViewModel()
){
    val lifecycleOwner = rememberUpdatedState(LocalLifecycleOwner.current)

    DisposableEffect(Unit) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                viewModel.getAllTasks() // Runs every time screen resumes (e.g. navigated back to)
            }
        }

        val lifecycle = lifecycleOwner.value.lifecycle
        lifecycle.addObserver(observer)

        onDispose {
            lifecycle.removeObserver(observer)
        }
    }

    val uiState = viewModel.uiState.collectAsState().value

    AppScaffold(
        topBar = {
            ThemedTopBar(
                title = { CircleAvatarWithBackground(imageUrl = "") },
                actions = {
                    ThemedIconButton(icon = Icons.Filled.Add) {
                        navigateToCreateTaskScreen()
                    }
                }
            )
        }
    ) {
        Column {
            Row {
                Text("Hello, ", style = MaterialTheme.typography.headlineMedium)
                Text("User", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row (
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ){
                TaskStatusCard(
                    icon = Icons.Filled.Star,
                    text = "Task Today",
                    numberOfTasks = 10,
                    modifier = Modifier.weight(1f)
                )
                TaskStatusCard(
                    icon = Icons.Default.DateRange,
                    text = "In Progress",
                    numberOfTasks = 8,
                    modifier = Modifier.weight(1f)
                )
            }
            Text(
                text = "Your tasks",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(vertical = 20.dp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxHeight()
            ) {
                items(uiState.tasks.size){
                    index ->
                        TaskOverviewCard(task = uiState.tasks[index])
                }
            }

        }

    }
}

@Preview
@Composable
fun TaskScreenPreview(){
    TaskScreen(
        navigateToCreateTaskScreen = {}
    )
}
package app.ies.taskbasket.ui.task

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object TaskScreen

fun NavController.navigateToTaskScreen(){
    navigate(TaskScreen)
}

fun NavGraphBuilder.taskScreen(
    navigateToCreateTaskScreen: () -> Unit
) {
    composable<TaskScreen> {
        TaskScreen(
            navigateToCreateTaskScreen
        )
    }
}
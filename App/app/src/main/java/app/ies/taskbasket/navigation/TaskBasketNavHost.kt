package app.ies.taskbasket.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import app.ies.taskbasket.ui.createTask.createTaskScreen
import app.ies.taskbasket.ui.createTask.navigateToCreateTaskScreen
import app.ies.taskbasket.ui.task.TaskScreen
import app.ies.taskbasket.ui.task.navigateToTaskScreen
import app.ies.taskbasket.ui.task.taskScreen

fun NavController.popCurrentScreen(){
    popBackStack()
}

@Composable
fun TaskBasketNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: Any = TaskScreen
) {
    NavHost(navController = navHostController, startDestination = startDestination, modifier = modifier) {
        taskScreen(
            navigateToCreateTaskScreen = navHostController::navigateToCreateTaskScreen
        )

        createTaskScreen(
            navigateToTaskScreen = navHostController::popCurrentScreen
        )
    }
}
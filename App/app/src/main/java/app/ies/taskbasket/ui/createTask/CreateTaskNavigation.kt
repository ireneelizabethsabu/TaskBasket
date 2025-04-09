package app.ies.taskbasket.ui.createTask

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object CreateTaskScreen

fun NavController.navigateToCreateTaskScreen(){
    navigate(CreateTaskScreen)
}


fun NavGraphBuilder.createTaskScreen(
    navigateToTaskScreen: () -> Unit
){
    composable<CreateTaskScreen> {
        CreateTaskScreen(
            navigateToTaskScreen = navigateToTaskScreen,
        )
    }
}
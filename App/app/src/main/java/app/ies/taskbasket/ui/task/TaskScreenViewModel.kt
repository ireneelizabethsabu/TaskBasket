package app.ies.taskbasket.ui.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.ies.taskbasket.domain.usecase.task.GetAllTasksUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class TaskScreenViewModel @Inject constructor(
    private val getAllTasksUseCase: GetAllTasksUseCase
) : ViewModel(){
    init {
        viewModelScope.launch {
            println(getAllTasksUseCase())
        }
    }
}
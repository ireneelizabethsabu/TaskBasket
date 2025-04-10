package app.ies.taskbasket.ui.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.ies.taskbasket.domain.usecase.task.GetAllTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskScreenViewModel @Inject constructor(
    private val getAllTasksUseCase: GetAllTasksUseCase
) : ViewModel(){

    val _uiState = MutableStateFlow(TaskUiState())
    val uiState = _uiState

    fun getAllTasks(){
        viewModelScope.launch {
//            val tasks = getAllTasksUseCase()
//            _uiState.update {
//                it.copy(tasks = tasks)
//            }
        }
    }
}
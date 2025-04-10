package app.ies.taskbasket.ui.createTask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.ies.taskbasket.data.models.TaskCreateRequest
import app.ies.taskbasket.domain.models.Task
import app.ies.taskbasket.domain.usecase.task.AddTaskUseCase
import app.ies.taskbasket.utils.UiState
import app.ies.taskbasket.utils.model.Priority
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class CreateTaskViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CreateTaskUiState())
    val uiState = _uiState.asStateFlow()

    fun onTitleChange(newTitle: String){
        _uiState.update {
            it.copy(title = newTitle)
        }
    }

    fun onDescriptionChange(newTitle: String){
        _uiState.update {
            it.copy(description = newTitle)
        }
    }

    fun onPriorityChanged(newPriority: Priority){
        _uiState.update {
            it.copy(priority = newPriority)
        }
    }

    fun onSelectedDateChanged(newDate: String){
        _uiState.update {
            it.copy(selectedDate = newDate)
        }
    }

    fun onShowDialogChanged(value: Boolean){
        _uiState.update {
            it.copy(
                showDatePicker = value
            )
        }
    }

    fun createTask(){
        val task = TaskCreateRequest(
            title = uiState.value.title,
            description = uiState.value.description,
            priority = uiState.value.priority,
        )
        viewModelScope.launch {
            addTaskUseCase(task).onSuccess {
                task ->
                _uiState.update {
                    it.copy(state =  UiState.Success(task) )
                }
            }.onFailure {
                error ->
                _uiState.update {
                    it.copy(state =  UiState.Error(error.message ?: "Error") )
                }
            }
        }
    }
}
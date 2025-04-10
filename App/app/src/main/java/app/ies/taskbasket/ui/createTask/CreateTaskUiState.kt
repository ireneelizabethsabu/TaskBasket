package app.ies.taskbasket.ui.createTask

import app.ies.taskbasket.utils.DateConverter
import app.ies.taskbasket.utils.UiState
import app.ies.taskbasket.utils.model.Priority

data class CreateTaskUiState(
    var state: UiState<Any> = UiState.Idle,
    var selectedDate: String = DateConverter.millisToDate(System.currentTimeMillis()),
    var showDatePicker: Boolean = false,
    var title: String = "",
    var description: String = "",
    var priority: Priority = Priority.Low,
)
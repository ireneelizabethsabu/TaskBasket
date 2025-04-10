package app.ies.taskbasket.ui.task

import app.ies.taskbasket.domain.models.Task

data class TaskUiState (
    val tasks: List<Task> = emptyList()
)
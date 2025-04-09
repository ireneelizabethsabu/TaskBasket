package app.ies.taskbasket.data.models

import app.ies.taskbasket.utils.model.Priority

data class TaskUpdateRequest(
    val title: String?,
    val description: String?,
    val isTaskOpen: Boolean?,
    val priority: Priority?,
    val isReminderSet: Boolean?
)

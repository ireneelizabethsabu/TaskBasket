package app.ies.taskbasket.data.models

data class TaskUpdateRequest(
    val title: String?,
    val description: String?,
    val isTaskOpen: Boolean?,
    val priority: Priority?,
    val isReminderSet: Boolean?
)

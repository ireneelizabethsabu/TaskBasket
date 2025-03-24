package app.ies.taskbasket.data.models



import java.time.LocalDateTime

data class TaskCreateRequest (
    val title: String,
    val description: String,
    val createdOn: LocalDateTime,
    val isTaskOpen: Boolean,
    val priority: Priority,
    val isReminderSet: Boolean
)
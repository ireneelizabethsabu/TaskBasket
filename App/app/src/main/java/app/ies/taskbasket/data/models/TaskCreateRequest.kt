package app.ies.taskbasket.data.models



import app.ies.taskbasket.utils.model.Priority
import java.time.LocalDateTime

data class TaskCreateRequest (
    val title: String,
    val description: String,
    val isTaskOpen: Boolean = true,
    val priority: Priority,
    val isReminderSet: Boolean = false
)
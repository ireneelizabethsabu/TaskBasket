package app.ies.taskbasket.data.models

import java.time.LocalDateTime

data class TaskDto (
    val id: Long,
    val title: String,
    val description: String,
    val createdOn: LocalDateTime,
    val isTaskOpen: Boolean,
    val priority: Priority,
    val isReminderSet: Boolean
)

enum class Priority {
    LOW, MEDIUM, HIGH
}
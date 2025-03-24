package app.ies.taskbasket.domain.models

import java.time.LocalDateTime

data class Task (
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
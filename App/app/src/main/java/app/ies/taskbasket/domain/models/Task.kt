package app.ies.taskbasket.domain.models

import app.ies.taskbasket.utils.model.Priority
import java.time.LocalDateTime

data class Task (
    val id: Long,
    val title: String,
    val description: String,
    val createdOn: LocalDateTime,
    val dueOn: LocalDateTime,
    val priority: Priority,
    val isTaskOpen: Boolean,
    val isReminderSet: Boolean,
    val percentDone: Int,
    val projectId: Long,
)


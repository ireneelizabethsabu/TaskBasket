package app.ies.taskbasket.data.models

import app.ies.taskbasket.domain.models.Task
import app.ies.taskbasket.utils.model.Priority
import java.time.LocalDateTime

data class TaskDto (
    val id: Long,
    val title: String,
    val description: String,
    val createdOn: LocalDateTime,
    val isTaskOpen: Boolean,
    val priority: Priority,
    val isReminderSet: Boolean
){
    fun toDomain() : Task {
        return Task(
            id = id,
            title = title,
            description = description,
            createdOn = createdOn,
            priority = priority,
            isTaskOpen = isTaskOpen,
            isReminderSet = isReminderSet
        )
    }
}


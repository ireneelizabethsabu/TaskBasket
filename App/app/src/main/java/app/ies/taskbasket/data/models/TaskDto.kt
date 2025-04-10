package app.ies.taskbasket.data.models

import app.ies.taskbasket.domain.models.Task
import app.ies.taskbasket.utils.model.Priority
import java.time.LocalDateTime

data class TaskDto (
    val id: Long,
    val title: String,
    val description: String,
    val createdOn: String,
    val dueOn: String,
    val priority: Priority,
    val isTaskOpen: Boolean,
    val isReminderSet: Boolean,
    val percentDone: Int,
    val projectId: Long,
){
    fun toDomain() : Task {
        return Task(
            id = id,
            title = title,
            description = description,
            createdOn = LocalDateTime.parse(createdOn),
            priority = priority,
            isTaskOpen = isTaskOpen,
            isReminderSet = isReminderSet,
            dueOn = LocalDateTime.parse(dueOn),
            percentDone = percentDone,
            projectId = projectId
        )
    }
}


package app.ies.taskbasket.data.models



import app.ies.taskbasket.domain.models.Project
import app.ies.taskbasket.utils.model.Priority
import java.time.LocalDateTime

data class TaskCreateRequest (
    val title: String,
    val description: String,
    val isTaskOpen: Boolean = true,
    val dueOn: String,
    val priority: Priority,
    val isReminderSet: Boolean = false,
    val percentDone: Int,
    val project: Project
)
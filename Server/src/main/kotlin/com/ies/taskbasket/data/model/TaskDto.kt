package com.ies.taskbasket.data.model

import com.ies.taskbasket.data.Task
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
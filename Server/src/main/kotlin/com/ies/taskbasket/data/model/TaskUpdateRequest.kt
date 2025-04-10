package com.ies.taskbasket.data.model

import java.time.LocalDateTime

data class TaskUpdateRequest(
    val title: String?,
    val description: String?,
    val dueOn: LocalDateTime?,
    val isTaskOpen: Boolean?,
    val priority: Priority?,
    val isReminderSet: Boolean?,
    val percentDone: Int?,
    val projectId: Long?
)

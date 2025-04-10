package com.ies.taskbasket.data.model

import java.time.LocalDateTime

data class TaskDto (
    val id: Long,
    val title: String,
    val description: String,
    val createdOn: LocalDateTime,
    val dueOn: LocalDateTime,
    val isTaskOpen: Boolean,
    val priority: Priority,
    val isReminderSet: Boolean,
    val percentDone: Int,
    val projectId: Long
)
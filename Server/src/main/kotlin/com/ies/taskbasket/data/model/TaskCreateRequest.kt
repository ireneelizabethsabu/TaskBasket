package com.ies.taskbasket.data.model

import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

data class TaskCreateRequest (
    @NotBlank(message = "title can't be empty")
    val title: String,
    val description: String,
    val isTaskOpen: Boolean,
    val priority: Priority,
    val isReminderSet: Boolean
)
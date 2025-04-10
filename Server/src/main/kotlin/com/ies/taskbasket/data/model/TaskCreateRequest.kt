package com.ies.taskbasket.data.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.ies.taskbasket.data.entity.Project
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

data class TaskCreateRequest (
    @NotBlank(message = "title can't be empty")
    val title: String,
    val description: String,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    val dueOn: LocalDateTime,
    val isTaskOpen: Boolean,
    val priority: Priority,
    val isReminderSet: Boolean,
    val percentDone: Int,
    val project: Project,
)
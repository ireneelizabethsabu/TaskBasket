package com.ies.taskbasket.mapper

import com.ies.taskbasket.data.entity.Project
import com.ies.taskbasket.data.entity.Task
import com.ies.taskbasket.data.model.TaskCreateRequest
import com.ies.taskbasket.data.model.TaskDto
import java.time.LocalDateTime

fun Task.toDto() : TaskDto = TaskDto(
    this.id,
    this.title,
    this.description,
    this.createdOn,
    this.dueOn,
    this.isTaskOpen,
    this.priority,
    this.isReminderSet,
    this.percentDone,
    this.project?.id ?: 0L
)


fun TaskCreateRequest.toEntity() : Task {
    val task = Task()
    task.title = this.title
    task.description = this.description
    task.createdOn = LocalDateTime.now()
    task.isTaskOpen = this.isTaskOpen
    task.priority = this.priority
    task.isReminderSet = this.isReminderSet
    task.dueOn = this.dueOn
    task.percentDone = this.percentDone
    task.project = this.project
    return task
}
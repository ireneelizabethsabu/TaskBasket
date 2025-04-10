package com.ies.taskbasket.service

import com.ies.taskbasket.data.entity.Task
import com.ies.taskbasket.data.model.TaskCreateRequest
import com.ies.taskbasket.data.model.TaskDto
import com.ies.taskbasket.data.model.TaskUpdateRequest
import com.ies.taskbasket.exception.BadRequestexception
import com.ies.taskbasket.exception.TaskNotFoundException
import com.ies.taskbasket.mapper.toDto
import com.ies.taskbasket.mapper.toEntity
import com.ies.taskbasket.repository.TaskRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.stream.Collectors

@Service
class TaskService(private  val taskRepository: TaskRepository) {

    private fun checkForTaskId(id: Long){
        if(!taskRepository.existsById(id)){
            throw  TaskNotFoundException("Task with ID: $id does not exist")
        }
    }

    fun getAllTasks(): List<TaskDto> =
        taskRepository.findAll().stream().map{ it.toDto() }.collect(Collectors.toList())

    fun getAllOpenTasks(): List<TaskDto> =
        taskRepository.queryAllOpenTasks().stream().map{ it.toDto() }.collect(Collectors.toList())

    fun getAllClosedTasks(): List<TaskDto> =
        taskRepository.queryAllClosedTasks().stream().map{ it.toDto() }.collect(Collectors.toList())

    fun getTaskById(id: Long): TaskDto {
        checkForTaskId(id)
        val task: Task = taskRepository.findTaskById(id)
        return  task.toDto()
    }

    fun createTask(request: TaskCreateRequest) : TaskDto{
        println(request)
        if(taskRepository.doesTitleExist(request.title)){
            throw BadRequestexception("Task with this title already exists")
        }
        val task = request.toEntity()
        val savedTask = taskRepository.save(task)
        return savedTask.toDto()
    }

    fun Task.updateWith(request: TaskUpdateRequest) : Task {
        request.title?.let { this.title = it }
        request.description?.let { this.description = it }
        request.isTaskOpen?.let { this.isTaskOpen = it }
        request.priority?.let { this.priority = it }
        request.isReminderSet?.let { this.isReminderSet = it }

        return this
    }

    fun updateTask(id: Long, request: TaskUpdateRequest) : TaskDto{
        checkForTaskId(id)
        val existingTask = taskRepository.findTaskById(id)
        val updatedTask = existingTask.updateWith(request)
        val savedTask = taskRepository.save(updatedTask)
        return savedTask.toDto()
    }

    fun deleteTask(id: Long) : String {
        checkForTaskId(id)
        taskRepository.deleteById(id)
        return "Task with id: $id has been deleted"
    }
}
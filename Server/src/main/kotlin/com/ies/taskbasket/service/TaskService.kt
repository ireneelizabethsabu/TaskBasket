package com.ies.taskbasket.service

import com.ies.taskbasket.data.Task
import com.ies.taskbasket.data.model.Priority
import com.ies.taskbasket.data.model.TaskCreateRequest
import com.ies.taskbasket.data.model.TaskDto
import com.ies.taskbasket.data.model.TaskUpdateRequest
import com.ies.taskbasket.exception.BadRequestexception
import com.ies.taskbasket.exception.TaskNotFoundException
import com.ies.taskbasket.repository.TaskRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TaskService(private  val taskRepository: TaskRepository) {
    private  fun convertEntityToDto(task: Task): TaskDto{
        return  TaskDto(
            task.id,
            task.title,
            task.description,
            task.createdOn,
            task.isTaskOpen,
            task.priority,
            task.isReminderSet
        )
    }

    private fun assignValuesToEntity(task: Task, taskRequest: TaskCreateRequest){
        task.title = taskRequest.title
        task.description = taskRequest.description
        task.createdOn = taskRequest.createdOn
        task.isTaskOpen = taskRequest.isTaskOpen
        task.priority = taskRequest.priority
        task.isReminderSet = taskRequest.isReminderSet
    }

    private fun checkForTaskId(id: Long){
        if(!taskRepository.existsById(id)){
            throw  TaskNotFoundException("Task with ID: $id does not exist")
        }
    }

    fun getAllTasks(): List<TaskDto> =
        taskRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList())

    fun getAllOpenTasks(): List<TaskDto> =
        taskRepository.queryAllOpenTasks().stream().map(this::convertEntityToDto).collect(Collectors.toList())

    fun getAllClosedTasks(): List<TaskDto> =
        taskRepository.queryAllClosedTasks().stream().map(this::convertEntityToDto).collect(Collectors.toList())

    fun getTaskById(id: Long): TaskDto {
        checkForTaskId(id)
        val task: Task = taskRepository.findTaskById(id)
        return  convertEntityToDto(task)
    }

    fun createTask(request: TaskCreateRequest) : TaskDto{
        if(taskRepository.doesTitleExist(request.title)){
            throw BadRequestexception("Task with this title already exists")
        }
        val task = Task()
        assignValuesToEntity(task, request)
        val savedTask = taskRepository.save(task)
        return convertEntityToDto(savedTask)
    }

    fun Task.updateWith(request: TaskUpdateRequest) : Task{
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
        return convertEntityToDto(savedTask)

    }

    fun deleteTask(id: Long) : String {
        checkForTaskId(id)
        taskRepository.deleteById(id)
        return "Task with id: $id has been deleted"
    }
}
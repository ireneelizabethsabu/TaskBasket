package app.ies.taskbasket.domain.repository

import app.ies.taskbasket.data.models.TaskCreateRequest
import app.ies.taskbasket.domain.models.Task
import app.ies.taskbasket.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun getAllTasks() : List<Task>
    suspend fun getTaskById(id: Long) : Task
    suspend fun createTask(task: TaskCreateRequest) : Result<Task>
    suspend fun deleteTask(id: Long)
    suspend fun updateTask(task: Task)
}
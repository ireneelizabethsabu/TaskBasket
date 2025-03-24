package app.ies.taskbasket.domain.repository

import app.ies.taskbasket.domain.models.Task
import app.ies.taskbasket.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun getAllTasks() : Flow<ResultState<List<Task>>>
    suspend fun getTaskById(id: Long) : Flow<ResultState<Task>>
    suspend fun createTask(task: Task)
    suspend fun deleteTask(id: Long)
    suspend fun updateTask(task: Task)
}
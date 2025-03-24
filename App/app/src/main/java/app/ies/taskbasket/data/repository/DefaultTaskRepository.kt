package app.ies.taskbasket.data.repository

import app.ies.taskbasket.domain.models.Task
import app.ies.taskbasket.domain.repository.TaskRepository
import app.ies.taskbasket.utils.ResultState
import kotlinx.coroutines.flow.Flow

class DefaultTaskRepository : TaskRepository {
    override suspend fun getAllTasks() : Flow<ResultState<List<Task>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTaskById(id: Long) : Flow<ResultState<Task>> {
        TODO("Not yet implemented")
    }

    override suspend fun createTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTask(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun updateTask(task: Task) {
        TODO("Not yet implemented")
    }
}
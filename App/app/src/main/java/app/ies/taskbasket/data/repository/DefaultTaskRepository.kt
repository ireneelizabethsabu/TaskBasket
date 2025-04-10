package app.ies.taskbasket.data.repository

import app.ies.taskbasket.data.api.TaskApiService
import app.ies.taskbasket.data.models.TaskCreateRequest
import app.ies.taskbasket.data.models.TaskDto
import app.ies.taskbasket.domain.models.Task
import app.ies.taskbasket.domain.repository.TaskRepository
import app.ies.taskbasket.utils.ResultState
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import javax.inject.Inject


class DefaultTaskRepository @Inject constructor(
    private val api: TaskApiService
) : TaskRepository {


    override suspend fun getAllTasks() : List<Task> {
        return api.getAllTasks().map { it.toDomain() }
    }

    override suspend fun getTaskById(id: Long) : Task {
        TODO("Not yet implemented")
    }

    override suspend fun createTask(task: TaskCreateRequest) : Result<Task> {
        try {
            val response =  api.createTask(task).toDomain()
            return Result.success(response)
        } catch (e: HttpException){
            return Result.failure(e)
        } catch (e: Exception){
            return Result.failure(e)
        }

    }

    override suspend fun deleteTask(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun updateTask(task: Task) {
        TODO("Not yet implemented")
    }
}
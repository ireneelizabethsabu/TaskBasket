package app.ies.taskbasket.data.api

import app.ies.taskbasket.data.models.TaskCreateRequest
import app.ies.taskbasket.data.models.TaskDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TaskApiService {
    @GET("all-tasks")
    suspend fun getAllTasks(): List<TaskDto>

    @GET("open-tasks")
    suspend fun getOpenTasks(): List<TaskDto>

    @POST("create")
    suspend fun createTask(@Body request: TaskCreateRequest): TaskDto
}
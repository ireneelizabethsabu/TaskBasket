package app.ies.taskbasket.data.api

import app.ies.taskbasket.data.models.TaskDto
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("all-tasks")
    suspend fun getAllTasks(): Call<List<TaskDto>>
}
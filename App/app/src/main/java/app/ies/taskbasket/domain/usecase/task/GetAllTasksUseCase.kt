package app.ies.taskbasket.domain.usecase.task

import app.ies.taskbasket.domain.repository.TaskRepository
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(){
        taskRepository.getAllTasks()
    }
}
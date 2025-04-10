package app.ies.taskbasket.domain.usecase.task

import app.ies.taskbasket.data.models.TaskCreateRequest
import app.ies.taskbasket.domain.models.Task
import app.ies.taskbasket.domain.repository.TaskRepository
import app.ies.taskbasket.utils.exceptions.CannotBeEmptyException
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(
    private  val taskRepository: TaskRepository
){
    suspend operator  fun invoke(task: TaskCreateRequest) : Result<Task> {
        if(task.title.isEmpty()){
            throw CannotBeEmptyException()
        }
        return taskRepository.createTask(task)
    }
}
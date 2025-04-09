package app.ies.taskbasket.di

import app.ies.taskbasket.data.repository.DefaultTaskRepository
import app.ies.taskbasket.domain.repository.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract  fun bindTaskRepository(
        defaultTaskRepository: DefaultTaskRepository
    ) : TaskRepository
}
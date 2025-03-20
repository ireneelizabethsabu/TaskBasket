package com.ies.taskbasket.repository

import com.ies.taskbasket.data.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : JpaRepository<Task,Long> {
    fun findTaskById(id: Long) : Task

    @Query(value = "SELECT * FROM task WHERE is_open = TRUE")
    fun queryAllOpenTasks(): List<Task>

    @Query(value = "SELECT * FROM task WHERE is_open = FALSE")
    fun queryAllClosedTasks(): List<Task>

    @Query(value = "SELECT CASE WHEN COUNT(t) > 0 THEN TRUE ELSE FALSE FROM task t WHERE t.description = ?1")
    fun doesTitleExist(title: String): Boolean
}
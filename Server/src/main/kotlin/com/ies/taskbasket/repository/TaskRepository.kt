package com.ies.taskbasket.repository

import com.ies.taskbasket.data.entity.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : JpaRepository<Task,Long> {
    fun findTaskById(id: Long) : Task

    @Query(value = "SELECT * FROM task WHERE is_open = TRUE", nativeQuery = true)
    fun queryAllOpenTasks(): List<Task>

    @Query(value = "SELECT * FROM task WHERE is_open = FALSE", nativeQuery = true)
    fun queryAllClosedTasks(): List<Task>

    @Query(value = "SELECT CASE WHEN COUNT(t) > 0 THEN TRUE ELSE FALSE END FROM Task t WHERE t.title = ?1")
    fun doesTitleExist(title: String): Boolean
}
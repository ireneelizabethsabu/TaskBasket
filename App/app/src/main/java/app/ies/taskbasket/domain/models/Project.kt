package app.ies.taskbasket.domain.models

import java.time.LocalDateTime

data class Project(
    val id: Long,
    val code: String,
    val name: String,
    val description: String,
    val isActive: Boolean,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime? = null
)
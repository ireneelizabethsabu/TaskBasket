package com.ies.taskbasket.data

import com.ies.taskbasket.data.model.Priority
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

@Entity
@Table(name = "task", uniqueConstraints = [UniqueConstraint(name = "unique_task_title", columnNames = ["title"])])
class Task {
    @Id
    @GeneratedValue(generator = "task_sequence", strategy = GenerationType.AUTO)
    val id: Long = 0

    @NotBlank
    @Column(name = "title", nullable = false, unique = true)
    var title: String = ""

    @Column(name = "description")
    var description: String = ""

    @Column(name = "created_on", nullable = false)
    var createdOn: LocalDateTime = LocalDateTime.now()

    @Column(name = "is_open", nullable = false)
    var isTaskOpen: Boolean = true

    @NotNull
    @Enumerated(EnumType.STRING)
    var priority: Priority = Priority.LOW

    @Column(name = "is_reminder_set", nullable = false)
    var isReminderSet: Boolean = false



}
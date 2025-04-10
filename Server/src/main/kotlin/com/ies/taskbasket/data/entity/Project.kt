package com.ies.taskbasket.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.time.LocalDateTime

@Entity
@Table(name = "project", uniqueConstraints = [UniqueConstraint(name = "unique_project_code", columnNames = ["code"])])
class Project {
    @Id
    @GeneratedValue(generator = "task_sequence", strategy = GenerationType.AUTO)
    val id: Long = 0

    @Column(name = "code", nullable = false, unique = true)
    var code: String = ""

    @Column(name = "name", nullable = false, unique = true)
    var name: String = ""

    @Column(name = "description")
    var description: String = ""

    @Column(name = "isActive")
    var isActive: Boolean = true

    @Column(name = "startDate", nullable = false)
    var startDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "endDate")
    var endDate: LocalDateTime? = null
}
package com.ies.taskbasket.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
data class TaskNotFoundException(
    override val message: String
): RuntimeException()

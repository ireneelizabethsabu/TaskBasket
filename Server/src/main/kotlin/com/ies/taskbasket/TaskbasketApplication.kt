package com.ies.taskbasket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskbasketApplication

fun main(args: Array<String>) {
	runApplication<TaskbasketApplication>(*args)
	println("Working")
}

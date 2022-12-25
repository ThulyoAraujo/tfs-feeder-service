package com.tulio.alimentador

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AlimentadorApplication

fun main(args: Array<String>) {
	runApplication<AlimentadorApplication>(*args)
}

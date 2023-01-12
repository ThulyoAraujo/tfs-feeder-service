package com.tulio.feeder

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FeederApplication

fun main(args: Array<String>) {
	runApplication<FeederApplication>(*args)
}

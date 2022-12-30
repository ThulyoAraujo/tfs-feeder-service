package com.tulio.alimentador

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(basePackages = ["com.tulio.alimentador.repository"]) // Para evitar erros de bean com repositório
@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class]) // Evita erro de url de banco
class AlimentadorApplication

fun main(args: Array<String>) {
	runApplication<AlimentadorApplication>(*args)
}

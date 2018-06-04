package com.endava.messanger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
@EnableReactiveMongoRepositories

class MessangerApplication

fun main(args: Array<String>) {
    runApplication<MessangerApplication>(*args)
}

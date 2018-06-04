package com.endava.messanger.repositories

import com.endava.messanger.entities.Message
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface MessageDao:ReactiveMongoRepository<Message,String>{
    fun findByCanAccessEveryOne(group:Set<String>): Flux<Message>
    fun findByCanAccessEquals(group:Set<String>):Flux<Message>;
}
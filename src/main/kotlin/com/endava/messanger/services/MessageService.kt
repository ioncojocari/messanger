package com.endava.messanger.services

import com.endava.messanger.entities.Message
import com.endava.messanger.repositories.MessageDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import org.springframework.util.StringUtils.startsWithIgnoreCase



@Service
class MessageService @Autowired constructor(var messageDao: MessageDao){

    fun save(message: Message): Mono<Message>{
        return messageDao.save(message);
    }

    fun getAll(usernames:Set<String>): Flux<Message> {
        var message:Message= Message();
        message.canAccess=usernames;
        var messageExample:Example<Message>;
        messageExample=Example.of(message);
        println(usernames)
        return messageDao.findAll(messageExample);
    }

    fun getAll():Flux<Message>{
        return messageDao.findAll();
    }

    fun deleteAll() {
        messageDao.deleteAll().subscribe()
    }
}
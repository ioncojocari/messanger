package com.endava.messanger.controllers

import com.endava.messanger.entities.Message
import com.endava.messanger.services.MessageService
import com.endava.messanger.utils.IAuthUtils
import com.endava.messanger.utils.SessionAuthUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebSession
import org.thymeleaf.expression.Sets
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.util.*
import javax.websocket.server.PathParam
import kotlin.collections.HashSet

@RestController
class MessageRestController @Autowired constructor(var authUtils: IAuthUtils,var messageService:MessageService){

    @PostMapping("/messages/{user}")
    fun addMessageToConversationWith(@PathVariable("user")whom:String, @RequestBody message:Message, ws:WebSession): Mono<Message> {
        var currentUsername:String?=authUtils.getCurrentUsername(ws);
        if(currentUsername==null){
            return Mono.empty();
        }
        message.username=currentUsername;
        message.canAccess= setOf<String>(whom,currentUsername);
        message.created= LocalDateTime.now();
        message.updated=message.created;
        return messageService.save(message)
    }

    @GetMapping("/messages/{user}")
    fun getConversationsWith(@PathVariable("user")whom:String,ws:WebSession): Flux<Message> {
        var currentUsername:String?=authUtils.getCurrentUsername(ws);
        if(currentUsername==null){
            return Flux.empty();
        }
        var access= setOf<String>(currentUsername,whom);
        return messageService.getAll(access);
    }

    @GetMapping("/messages")
    fun getAll():Flux<Message>{
        return messageService.getAll();
    }


}
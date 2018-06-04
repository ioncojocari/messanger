package com.endava.messanger.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
class Message {
    @Id
    lateinit var id: String
    //canAccess is a list of users that can access this message
    lateinit var canAccess: Set<String>
    lateinit var username: String
    lateinit var message: String
    lateinit var created: LocalDateTime
    lateinit var updated: LocalDateTime
}
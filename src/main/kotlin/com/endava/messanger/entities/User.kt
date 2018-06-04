package com.endava.messanger.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
class User {
    @Id
    @JsonIgnore
    lateinit var id:String
    @Indexed(unique=true, sparse=true)
    lateinit var username:String
}
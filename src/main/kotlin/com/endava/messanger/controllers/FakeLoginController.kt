package com.endava.messanger.controllers

import org.springframework.boot.web.servlet.server.Session
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.SessionAttribute

import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import org.springframework.web.server.ServerWebExchange
import javax.servlet.http.HttpSession
import org.springframework.data.mongodb.core.mapreduce.GroupBy.key
import org.springframework.web.server.WebSession
import reactor.core.publisher.Mono
import reactor.util.context.Context


@RestController
class FakeLoginController {

    @GetMapping("/login/{username}")
    fun login(@PathVariable("username") username: String, session: WebSession): Any? {
        session.attributes.put("username", username)
        return session.attributes.get("username");
    }

}
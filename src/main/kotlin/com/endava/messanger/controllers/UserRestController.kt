package com.endava.messanger.controllers

import com.endava.messanger.entities.User
import com.endava.messanger.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class UserRestController @Autowired constructor(var userService:UserService) {

    @PostMapping("/users")
    fun saveUser(@RequestBody user: User): Mono<User> {
        return userService.save(user);
    }

    @GetMapping("/users")
    fun getAllUsers(): Flux<User> {
        return userService.getAllUsers();
    }
}
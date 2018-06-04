package com.endava.messanger.services

import com.endava.messanger.entities.User
import com.endava.messanger.repositories.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService @Autowired constructor(var userDao:UserDao) {

    open fun save(user: User): Mono<User> {
        return userDao.save(user);
    }

    open fun getAllUsers(): Flux<User> {
        return userDao.findAll();
    }

}
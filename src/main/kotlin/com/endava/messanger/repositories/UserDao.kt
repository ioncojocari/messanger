package com.endava.messanger.repositories

import com.endava.messanger.entities.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao : ReactiveMongoRepository<User,String> {
}




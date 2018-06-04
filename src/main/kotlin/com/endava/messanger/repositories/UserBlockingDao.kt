package com.endava.messanger.repositories

import com.endava.messanger.entities.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserBlockingDao : MongoRepository<User,String> {

}
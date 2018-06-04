package com.endava.messanger.configs

import com.endava.messanger.utils.IAuthUtils
import com.endava.messanger.utils.SessionAuthUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MyConfigurations {

    @Bean
    fun getAuthUtils(): IAuthUtils {
        return SessionAuthUtils();
    }

}
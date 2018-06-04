package com.endava.messanger.utils

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebSession

@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
class SessionAuthUtils :IAuthUtils{

    override fun getCurrentUsername(sr: WebSession):String?{
        return sr.getAttribute("username");
    }
}
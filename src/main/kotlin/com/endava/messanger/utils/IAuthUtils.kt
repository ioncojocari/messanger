package com.endava.messanger.utils

import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebSession

interface IAuthUtils {
    fun getCurrentUsername(sr: WebSession):String?;
}
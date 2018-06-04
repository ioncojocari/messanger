package com.endava.messanger.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class TestController {

    @GetMapping("/test")
    @ResponseBody
    fun test():String {
        return "test";
    }
}
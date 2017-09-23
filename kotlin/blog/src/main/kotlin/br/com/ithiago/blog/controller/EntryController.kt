package br.com.ithiago.blog.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EntryController {

    @GetMapping("/entry")
    fun getAll() : String {
        return "Hello world"
    }
}


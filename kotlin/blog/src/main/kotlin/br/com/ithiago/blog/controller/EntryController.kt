package br.com.ithiago.blog.controller

import br.com.ithiago.blog.service.EntryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EntryController (val entryService: EntryService) {

    @GetMapping("/entry")
    fun getAll() : String {
        return entryService.getHello()
    }
}


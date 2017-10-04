package br.com.ithiago.blog.service

import org.springframework.stereotype.Service

@Service
open class EntryService {


    fun getHello(): String {
        return "Hello penta campeao"
    }
}
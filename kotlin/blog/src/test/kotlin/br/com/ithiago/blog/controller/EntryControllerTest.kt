package br.com.ithiago.blog.controller

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(EntryController::class), webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EntryControllerTest {

    @Autowired
    lateinit var testRestTemplate : TestRestTemplate

    @Test
    fun whenCalledShouldReturnHello() {
        val result = testRestTemplate.getForEntity("/entry", String::class.java)

        Assert.assertNotNull(result)
        Assert.assertEquals(HttpStatus.OK, result?.statusCode)
        Assert.assertEquals("Thiago", result?.body)
    }
}
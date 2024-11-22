package com.example

import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.client.request.*
import io.ktor.client.statement.*

class CalculatorApiTest {

    @Test
    fun `test add endpoint`() = testApplication {
        application {
            configureSerialization()
            configureRouting()
        }
        val response = client.get("/add?num1=10&num2=5")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("{\"result\":15.0}", response.bodyAsText())
    }

    @Test
    fun `test subtract endpoint`() = testApplication {
        application {
            configureSerialization()
            configureRouting()
        }
        val response = client.get("/subtract?num1=10&num2=5")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("{\"result\":5.0}", response.bodyAsText())
    }

    @Test
    fun `test multiply endpoint`() = testApplication {
        application {
            configureSerialization()
            configureRouting()
        }
        val response = client.get("/multiply?num1=10&num2=5")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("{\"result\":50.0}", response.bodyAsText())
    }

    @Test
    fun `test divide endpoint`() = testApplication {
        application {
            configureSerialization()
            configureRouting()
        }
        val response = client.get("/divide?num1=10&num2=5")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("{\"result\":2.0}", response.bodyAsText())
    }

    @Test
    fun `test divide by zero`() = testApplication {
        application {
            configureSerialization()
            configureRouting()
        }
        val response = client.get("/divide?num1=10&num2=0")
        assertEquals(HttpStatusCode.BadRequest, response.status)
        assertEquals("Erro: Divisão por zero", response.bodyAsText())
    }
}



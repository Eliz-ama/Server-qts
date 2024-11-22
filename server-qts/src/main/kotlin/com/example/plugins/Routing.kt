package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    routing {
        // Endpoint de teste
        get("/") {
            call.respondText("Hello, Calculadora API!")
        }

        // Rota para Adição
        get("/add") {
            val num1 = call.request.queryParameters["num1"]?.toDoubleOrNull()
            val num2 = call.request.queryParameters["num2"]?.toDoubleOrNull()

            if (num1 != null && num2 != null) {
                val result = num1 + num2
                call.respond(mapOf("result" to result))
            } else {
                call.respondText("Parâmetros inválidos", status = io.ktor.http.HttpStatusCode.BadRequest)
            }
        }

        // Rota para Subtração
        get("/subtract") {
            val num1 = call.request.queryParameters["num1"]?.toDoubleOrNull()
            val num2 = call.request.queryParameters["num2"]?.toDoubleOrNull()

            if (num1 != null && num2 != null) {
                val result = num1 - num2
                call.respond(mapOf("result" to result))
            } else {
                call.respondText("Parâmetros inválidos", status = io.ktor.http.HttpStatusCode.BadRequest)
            }
        }

        // Rota para Multiplicação
        get("/multiply") {
            val num1 = call.request.queryParameters["num1"]?.toDoubleOrNull()
            val num2 = call.request.queryParameters["num2"]?.toDoubleOrNull()

            if (num1 != null && num2 != null) {
                val result = num1 * num2
                call.respond(mapOf("result" to result))
            } else {
                call.respondText("Parâmetros inválidos", status = io.ktor.http.HttpStatusCode.BadRequest)
            }
        }

        // Rota para Divisão
        get("/divide") {
            val num1 = call.request.queryParameters["num1"]?.toDoubleOrNull()
            val num2 = call.request.queryParameters["num2"]?.toDoubleOrNull()

            if (num1 != null && num2 != null) {
                if (num2 != 0.0) {
                    val result = num1 / num2
                    call.respond(mapOf("result" to result))
                } else {
                    call.respondText("Erro: Divisão por zero", status = io.ktor.http.HttpStatusCode.BadRequest)
                }
            } else {
                call.respondText("Parâmetros inválidos", status = io.ktor.http.HttpStatusCode.BadRequest)
            }
        }
    }
}

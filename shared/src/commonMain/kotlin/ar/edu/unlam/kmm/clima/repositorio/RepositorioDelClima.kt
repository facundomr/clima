package ar.edu.unlam.kmm.clima.repositorio

import ar.edu.unlam.kmm.clima.initLogger
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class RepositorioDelClima {

    val httpClient = HttpClient() {
        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HttpClient", message = message)
                }
            }
            logger
        }
    }.also {
        initLogger()
    }

    suspend fun obtenerClima(): String {
        val response: HttpResponse =
            httpClient.get("https://api.jsonbin.io/b/614defac4a82881d6c54cbe9")
        return response.readText()
    }
}
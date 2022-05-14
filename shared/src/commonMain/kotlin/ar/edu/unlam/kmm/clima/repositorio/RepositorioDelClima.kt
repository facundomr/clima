package ar.edu.unlam.kmm.clima.repositorio

import ar.edu.unlam.kmm.clima.initLogger
import ar.edu.unlam.kmm.clima.modelo.Clima
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class RepositorioDelClima {

    private val httpClient = HttpClient {
        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HttpClient", message = message)
                }
            }
            logger
        }
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }.also {
        initLogger()
    }

    suspend fun obtenerClima(): Clima =
        httpClient.get("https://api.jsonbin.io/b/614defac4a82881d6c54cbe9").body()

}
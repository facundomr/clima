package ar.edu.unlam.kmm.clima.repositorio

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class RepositorioDelClima {

    val httpClient = HttpClient()

    suspend fun obtenerClima(): String {
        val response: HttpResponse = httpClient.get("https://api.jsonbin.io/b/614defac4a82881d6c54cbe9")
        return response.readText()
    }
}
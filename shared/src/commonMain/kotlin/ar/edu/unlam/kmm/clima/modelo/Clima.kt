package ar.edu.unlam.kmm.clima.modelo

import kotlinx.serialization.Serializable

@Serializable
data class Clima(
    val estado: String,
    val temperatura: String,
)
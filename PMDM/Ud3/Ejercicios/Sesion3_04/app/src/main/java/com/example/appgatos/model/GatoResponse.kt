package com.example.appgatos.model

data class GatoResponse (
    val `data`: List<Gato> = emptyList(),
    val status: String = ""

)
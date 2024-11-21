package com.example.appmusica.Model

sealed class Encuesta (val pregunta:String, val respuestas:List<String>){
    object EncuestaHoy:Encuesta(
        "Cual es el modulo que menos te gusta?", listOf("AD", "DI", "PSP", "PMDM")
    )
    object EncuestaManana:Encuesta(
        "Que grado de satisfaccion tienes con el profe de PMDM?", listOf("Totalmente satisfecho", "Bastante satisfecho", "Poco satisfecho", "Nada satisfecho")
    )
}
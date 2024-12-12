package com.example.sesion3_03_base.Model

/*
* Para crear los data class del modelo podrías usar el plugin Json to Kotlin Class.

•	Instala el plugin.
•	Elimina las clases anteriores.
•	En package model, selecciona New Kotlin Data Class From Json. Pega la respuesta JSON de la api para obtener un animal de forma aleatoria.
•	Finaliza y verás que se han creado los data class completos.

* */
data class AnimalResponse(
    val `data`: List<Animal>,
    val status: String
)
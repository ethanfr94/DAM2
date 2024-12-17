package com.example.sesion3_04.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java

/*
* 5.- Utilización de Retrofit. Retrofit es una librería para realizar procesos de consumo de una API web service.
* •	Incluimos dependencias de retrofit y del conversor JSON-Objetos en retrofit:
* // Retrofit
* implementation("com.squareup.retrofit2:retrofit:2.9.0")
* implementation("com.squareup.retrofit2:converter-gson:2.9.0")
* Creamos una interface que contenga la estructura de las peticiones al servidor (a la API). (RetrofitService)
* Lo creamos en el package data.
* Declaramos una sola función anotada con GET para el endpoint animal. (@GET("animal/"))
* La función es de tipo suspend ya que deberá incluir una corrutina,
* La función debe devolver un objeto AnimalResponse (es lo que nos devuelve la API, aunque en formato JSON)
* A continuación de la declaración del interface, lo implementamos mediante un objeto que se encargará de crear la instancia de la interfaz.
* En el ViewModel construimos el servicio Retrofit. En la función getRandomAnimal()
* sustituimos código para que use el servicio Retrofit para obtener un AnimalResponse con la función del interface.
*
*/

interface RetrofitService {
    @retrofit2.http.GET("gato/")
    suspend fun getGato(): com.example.sesion3_04.Model.GatoResponse
    // Otros métodos de la API si los necesitas
    @retrofit2.http.GET("gato/{id}")
    suspend fun getAnimalById(@retrofit2.http.Path("id") id: Int): com.example.sesion3_04.Model.GatoResponse
}

object RetrofitServiceFactory {
    fun makeRetrofitService(): com.example.sesion3_04.Model.RetrofitService {
        return Retrofit.Builder()
            //url base de la api
            .baseUrl("https://extinct-api.herokuapp.com/api/v1/")
            //usar convertidor de JSON
            .addConverterFactory(GsonConverterFactory.create())
            //construir
            .build().create(com.example.sesion3_04.Model.RetrofitService::class.java)
    }
}
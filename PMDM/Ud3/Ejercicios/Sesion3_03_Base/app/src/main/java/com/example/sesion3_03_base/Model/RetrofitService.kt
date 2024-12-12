package com.example.sesion3_03_base.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

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
    @GET("animal/")
    suspend fun getRandomAnimal(): AnimalResponse
    // Otros métodos de la API si los necesitas
    @GET("animal/{id}")
    suspend fun getAnimalById(@Path("id") id: Int): AnimalResponse
}

object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            //url base de la api
            .baseUrl("https://extinct-api.herokuapp.com/api/v1/")
            //usar convertidor de JSON
            .addConverterFactory(GsonConverterFactory.create())
            //construir
            .build().create(RetrofitService::class.java)
    }
}
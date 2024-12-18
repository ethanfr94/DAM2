package com.example.appgatos.data

import com.example.appgatos.model.Gato
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// Interfaz para las peticiones de la API
interface GatosApi {
    @GET("gatos/")
    suspend fun getGatos(): List<Gato>

    @POST("gatos")
    suspend fun addGato(@Body gato: Gato): Response<Gato> //@Body le dice a Retrofit que envíe el objeto en el cuerpo de la solicitud HTTP
}

// Objeto para crear la instancia de Retrofit
object RetrofitServiceFactory {
    fun makeRetrofitService(): GatosApi {
        return Retrofit.Builder()
            .baseUrl("https://crudcrud.com/api/189d5cc348b545ee8892ce66ac9830ed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GatosApi::class.java)
    }
}









import com.example.sesion3_03_base.data.GatosApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Objeto para crear la instancia de Retrofit y el servicio

object RetrofitInstance {
    private const val BASE_URL = "https://crudcrud.com/api/189d5cc348b545ee8892ce66ac9830ed/"

    val api: GatosApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GatosApi::class.java)
    }
}

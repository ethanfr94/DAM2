package com.example.sesion3_05.View

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sesion3_05.Data.Database.AppDatabase
import com.example.sesion3_05.Data.Entities.Animal
import com.example.sesion3_05.Data.Entities.Familia
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
 1.- HomeViewModel.kt  para el ViewModel de las vistas a usar. El archivo contiene:
•	Un LiveData para proveer una lista de animales y otro para proveer un animal.
•	Una función para obtener un animal de la tabla de animales a partir de su id.
•	Una función para insertar en la tabla de familias el contenido de una lista de familias.
•	Una función que devuelve en una lista todos los animales de la tabla de animales y la asigna al LiveData.
•	Una función iniciar que añade una lisa de animales a la tabla de animales y después obtiene en una lista todos los animales de la tabla.

 */

class HomeViewModel(private val appDatabase: AppDatabase) : ViewModel() {
    // LiveData para servir la lista de animales
    private val _animales = MutableLiveData<List<Animal>>()
    val animales: LiveData<List<Animal>> = _animales
    // LiveData para servir una animal
    private val _animal = MutableLiveData<Animal?>()
    val animal: MutableLiveData<Animal?> = _animal

    // Función para obtener un animal por su id
    fun obtenerAnimal(id: Int) {
        // Utilizar corrutina para realizar la operación en un hilo separado
        viewModelScope.launch(Dispatchers.IO) {
            val animal = appDatabase.animalDao().getAnimalById(id)
            _animal.postValue(animal)
        }
    }

    // Función para obtener en la lista del LiveData los animales desde la base de datos
    fun obtenerAnimales() {
        // Utilizar corrutina para realizar la operación en un hilo separado
        viewModelScope.launch(Dispatchers.IO) {
            val lista = appDatabase.animalDao().getAllAnimales()
            _animales.postValue(lista)

        }

    }

    fun insertarFamilias() {
        val familias = listOf(
            Familia(id=1,nombre = "Cérvidos", descripcion = "Familia de los ciervos, renos y alces."),
            Familia(id=2,nombre = "Bóvidos", descripcion = "Familia de los toros, búfalos y antílopes."),
            Familia(id=3,nombre = "Mustélidos", descripcion = "Familia de los tejones, nutrias y hurones.")
        )
        viewModelScope.launch {
            // Inserta cada familia en la base de datos usando corrutina
            familias.forEach { familia ->
                appDatabase.familiaDao().insertFamilia(familia)
                Log.i("ACCESO_ROOM_INS", familia.nombre)
            }
        }

    }

    // 4.1.- Creamos una función para eliminar que llama a delete del DAO y vuelve a recargar la lista de animales
    // (esta recarga es necesaria porque si no se hace, el ViewModel no notifica su modificación y por ello
    // no se vería la lista de animales actualizada

    // Función para eliminar un animal
    fun eliminarAnimal(animal: Animal) {
        viewModelScope.launch(Dispatchers.IO) {
            appDatabase.animalDao().deleteAnimal(animal)
            obtenerAnimales() // Recargar la lista de animales
        }
    }



    //funcion iniciar
    //hace una carga inicial de animales en una tabla para prueba
    //tras añadir llama a la función para obtener en una lista de los aniamles
    fun iniciar() {
        val animales = listOf(
            Animal(nombre = "Ciervo rojo", caracteristicas = "Gran tamaño, cornamenta ramificada en los machos, presente en bosques y montañas.", imagenUrl = "https://example.com/ciervo_rojo.jpg", familiaId = 1),
            Animal(nombre = "Corzo", caracteristicas = "Más pequeño que el ciervo, cornamenta corta y recta, activo al amanecer y al atardecer.", imagenUrl = "https://example.com/corzo.jpg", familiaId = 1),
            Animal(nombre = "Tejón europeo", caracteristicas = "Pelaje grisáceo, bandas negras en la cara, nocturno y excava madrigueras profundas.", imagenUrl = "https://example.com/tejon_europeo.jpg", familiaId = 3),
            Animal(nombre = "Nutria europea", caracteristicas = "Mamífero semiacuático, cuerpo alargado y patas palmeadas, vive en ríos y lagos.", imagenUrl = "https://example.com/nutria_europea.jpg", familiaId = 3),
            Animal(nombre = "Garduña", caracteristicas = "Mamífero ágil, pelaje marrón, marca blanca en el pecho, habita bosques y áreas rurales.", imagenUrl = "https://example.com/garduna.jpg", familiaId = 3)
        )

// Insertar en la base de datos usando corrutina
        viewModelScope.launch {
            animales.forEach { animal ->
                appDatabase.animalDao().insertAnimal(animal)
            }
            obtenerAnimales()
        }
    }
}
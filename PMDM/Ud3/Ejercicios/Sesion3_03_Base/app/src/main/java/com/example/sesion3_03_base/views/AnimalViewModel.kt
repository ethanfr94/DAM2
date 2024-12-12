package com.example.sesion3_03_base.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sesion3_03_base.Model.Animal
import com.example.sesion3_03_base.Model.RetrofitServiceFactory

/*
 *4.- Ahora modificamos lo necesario en el código para que se use ViewModel
 * Incluir librería para viewmodel: implementation(libs.androidx.runtime.livedata)
 * Crear una clase para el ViewModel. class AnimalViewModel(): ViewModel() { }
 * Declarar en la clase AnimalViewModel un LiveData para el animal que se vaya obteniendo de la API.
 * Añadir una función que carga los datos de un nuevo animal. getAnimalRandom()
 * HomeView tiene que recibir el ViewModel:
 * fun HomeView(viewModel:AnimalViewModel) {
 * val animal: Animal? by viewModel.animal.observeAsState() ....}
 * asignar a los elementos de la vista los valores del animal que se obtiene del ViewModel.
 * Programar el botón SIGUIENTE para que, al clicar, llame a la función getAnimalRandom del ViewModel.
 * onClick = { viewModel.getAnimalRandom()}
 * en MainActivity hay que construir el ViewModel y pasárselo a HomeView.
 * val viewModel by viewModels<AnimalViewModel>()
 * HomeView(viewModel,service)
*/

class AnimalViewModel() : ViewModel() {
    //Instancia del servicio retrofit
    val service= RetrofitServiceFactory.makeRetrofitService()

    //LiveData para estado actual de Animal
    private val _animal= MutableLiveData<Animal?>(
        Animal(imageSrc = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Perru_disparue.jpg/220px-Perru_disparue.jpg",
        )
    )
    val animal: LiveData<Animal?> = _animal

    //Función para obtener un animal aleatorio
    fun getAnimalRandom(){
        val newAnimal=Animal(
            commonName = "Club-tailed glyptodont",
            location =  "South American Pampas",
            imageSrc = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Doedicurus.png/220px-Doedicurus.png" ,
            lastRecord = "4765-4445 BCE"
        )
        _animal.value = newAnimal
    }


}
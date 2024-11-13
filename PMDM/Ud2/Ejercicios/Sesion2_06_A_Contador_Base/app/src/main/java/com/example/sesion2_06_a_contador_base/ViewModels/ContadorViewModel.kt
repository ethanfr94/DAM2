package com.example.sesion2_06_a_contador_base.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel() {
    // LiveData para el contador
    private val _contador = MutableLiveData<Int>()
    val contador: LiveData<Int> = _contador

    fun add(){
        // _contador no es Int sino MutableLiveData<Int>
        // por lo que se debe asignar el valor de _contador.value a una variable temporal
        // para poder modificarla y luego asignarla a _contador.value
         val cont = _contador.value?:0
         _contador.value = cont + 1
    }
}
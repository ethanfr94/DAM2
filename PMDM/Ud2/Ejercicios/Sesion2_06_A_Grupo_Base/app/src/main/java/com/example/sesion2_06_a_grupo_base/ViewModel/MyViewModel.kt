package com.example.sesion2_06_a_grupo_base.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private val _valores = MutableLiveData<List<Int>>()
    val valores: LiveData<List<Int>> = _valores

    fun generarValores(){
        _valores.value = (1..16).shuffled().take(4).sorted()
    }

}
package com.example.appgatos.views

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appgatos.data.RetrofitServiceFactory
import com.example.appgatos.model.Gato
import kotlinx.coroutines.launch

class GatoViewModel : ViewModel() {


    private val _gatos = MutableLiveData<List<Gato>>()

    val gatos: LiveData<List<Gato>> = _gatos

    private val service = RetrofitServiceFactory.makeRetrofitService()
    private val _selectedGato = MutableLiveData<Gato?>()
    val selectedGato: LiveData<Gato?> = _selectedGato


    fun getGatos() {
        viewModelScope.launch {
            try {
                val gatosList = service.getGatos()
                _gatos.value = gatosList
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun getGatoById(id: String) {
        viewModelScope.launch {
            try {
                val gato = _gatos.value?.find { it.id == id }
                _selectedGato.value = gato
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun addGato(gato: Gato){
        viewModelScope.launch {
            try {
                RetrofitInstance.api.addGato(gato)
                getGatos()
            } catch (e: Exception) {
                Log.e("GatoViewModel", "Error al agregar gato", e)
            }
        }
    }

    init {
        getGatos()
    }
}

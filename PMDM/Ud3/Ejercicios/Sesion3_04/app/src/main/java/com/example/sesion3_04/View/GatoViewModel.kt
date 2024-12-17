package com.example.sesion3_04.View

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sesion3_04.Model.Gato

class GatoViewModel(): ViewModel() {
        //LiveData para estado actual de Animal
        private val _gato = MutableLiveData<Gato?>(
            Gato(
                id = 0,
                raza = "Gato",
                origen = "",
                imagenURL = "https://s3.abcstatics.com/abc/www/multimedia/sociedad/2024/07/11/gato-RaZLibek03KjY2lBzGD2qEN-1200x840@diario_abc.jpg"
            )
        )
        val gato: LiveData<Gato?> = _gato


}
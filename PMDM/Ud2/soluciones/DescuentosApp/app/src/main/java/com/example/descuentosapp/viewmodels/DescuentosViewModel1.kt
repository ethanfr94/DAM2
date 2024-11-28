package com.example.descuentosapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.round


class DescuentosViewModel1 : ViewModel(){

    private val _descuentoText=MutableLiveData<String>("")
    var descuentoText: LiveData<String> = _descuentoText

    private val _precioText=MutableLiveData<String>("")
    var precioText: LiveData<String> = _precioText

    private val _descuentoTot=MutableLiveData<Double>(0.0)
    var descuentoTot: LiveData<Double> = _descuentoTot

    private val _precioTot=MutableLiveData<Double>(0.0)
    var precioTot: LiveData<Double> = _precioTot

    private val _showAlert=MutableLiveData<Boolean>(false)
    val showAlert:LiveData<Boolean> = _showAlert

    fun actualizarPrecio(nuevoPrecio: String) {
        _precioText.value = if (nuevoPrecio.toDoubleOrNull() != null) nuevoPrecio else ""
    }

    fun actualizarDescuento(nuevoDescuento: String) {
        _descuentoText.value = if (nuevoDescuento.toDoubleOrNull() != null) nuevoDescuento else ""
    }

    fun generar() {
        if(precioText.value != "" && descuentoText.value != ""){
            val precio=_precioText.value?.toDoubleOrNull()?:0.0
            val descuento=_descuentoText.value?.toDoubleOrNull()?:0.0
            calcular(precio, descuento)

        }else{
            _showAlert.value = true
        }
    }

    private fun calcular(precio:Double, descuento:Double){
        val descuentoCalc = round(precio*descuento)/100.0
        val precioCalc=precio-descuentoCalc
        _precioTot.value=precioCalc
        _descuentoTot.value=descuentoCalc
    }

    fun desactivaAlerta() {
        _showAlert.value=false
    }

    fun iniciar() {
     _precioText.value=""
     _descuentoText.value=""
     _descuentoTot.value=0.0
     _precioTot.value=0.0

    }


}
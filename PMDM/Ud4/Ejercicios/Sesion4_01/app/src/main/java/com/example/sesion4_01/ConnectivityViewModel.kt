package com.example.sesion4_01

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class ConnectivityViewModel(application: Application) : AndroidViewModel(application) {
    //contexto de la aplicación
    private val context = application.applicationContext

    private val _isConnected = MutableLiveData<Boolean>(false) // Conectividad
    val isConnected: LiveData<Boolean> = _isConnected

    private val _content = MutableLiveData<String>()
    val content: LiveData<String> = _content

    private val _showMobileDataDialog = MutableLiveData<Boolean>(false) // Mostrar diálogo
    val showMobileDataDialog: LiveData<Boolean> = _showMobileDataDialog

    private val _isUsingMobileData = MutableLiveData<Boolean>(false) // Uso de datos móviles
    val isUsingMobileData: LiveData<Boolean> = _isUsingMobileData

    private val _errorMessage = MutableLiveData<String>("") // Mensaje de error
    val errorMessage: LiveData<String> = _errorMessage

    init {
        checkConnectivity()
    }

    // Verifica conectividad (WiFi o datos móviles)
    private fun checkConnectivity() {
        //obtener el servicio de conectividad
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        //obtener las capacidades de red activas (WiFi, datos móviles, VPN, Ethernet)
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        //variable que comprueba si una de las redes activas es WIFI
        val isWifiConnected =
            networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true
        //variable que indica si hay conexión de datos móviles
        val isMobileDataConnected =
            networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true

        if (isWifiConnected) {
            _isConnected.postValue(true)
        } else if (isMobileDataConnected) {
            _showMobileDataDialog.postValue(true) // Preguntar si usar datos móviles
        } else {
            _isConnected.postValue(false)
            _errorMessage.postValue("No hay conexión de red.")
        }


    }

    // Usuario aceptó usar datos móviles
    fun acceptUsingMobileData() {
        //se usan datos móviles
        _isUsingMobileData.postValue(true)
        //ya no hay que mostrar el cuadro de diálogo
        _showMobileDataDialog.postValue(false)
    }

    // Descargar contenido desde URL
    fun downloadContent(url: String) {
        if (url.isEmpty()) {
            _content.postValue("Ingrese una URL válida.")
            return
        }
        // Haz la descarga en un hilo separado
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Obten todo el texto del recurso desde la URL
                val downloadedContent = URL(url).readText()
                // Carga ese texto en el LiveData
                withContext(Dispatchers.Main) {
                    _content.postValue(downloadedContent)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    _content.postValue("Error al descargar el contenido.")
                }
            }
        }

    }
}

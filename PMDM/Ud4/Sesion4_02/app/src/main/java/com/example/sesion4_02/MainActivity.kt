package com.example.sesion4_02

import android.annotation.SuppressLint
import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sesion4_02.ui.theme.Sesion4_02Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                content = {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.height(50.dp))
                        SensoresView()
                    }

                }
            )

        }
    }
}

// 1.1.- Crea un composable SensoresView para visualizar la lista de sensores.

@Composable
fun SensoresView() {

    // 1.2.- En SensoresView crea una variable context para el contexto de la aplicación.

    val context = LocalContext.current

    // 1.3.- Crea una variable de estado para gestionar el acceso a los sensores

    // Obtener el SensorManager del sistema
    val sensorManager = remember {
        // getSystemService se usa para acceder al servicio de sensores
        context.getSystemService(SENSOR_SERVICE) as SensorManager
    }

    // 1.4.- Obtener una lista de objetos Sensor con información de los sensores del dispositivo

    // Obtener la lista de sensores disponibles
    val sensorList = remember {
        // con TYPE_ALL Devuelve todos los sensores disponibles
        sensorManager.getSensorList(Sensor.TYPE_ALL)
    }

    // 1.5.- Sabiendo que cada elemento de esa lista es un objeto Sensor, escribir en pantalla una
    // lista con el texto del tipo y nombre del tipo de cada sensor

    // Mostrar la lista de sensores
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(sensorList.size) { index ->
            val sensor = sensorList[index]
            Text(text = "Tipo: ${sensor.type}, Nombre: ${sensor.name}")
        }
    }


}


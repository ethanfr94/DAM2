package com.example.sesion4_02_3

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sesion4_02_3.ui.theme.Sesion4_02_3Theme


/*
3.- Debes realizar una app que obtiene valores de como esta colocado tridimensionalmente
 el dispositivo. Esto se puede realizar con el sensor de rotación o con el acelerómetro.

El acelerómetro detecta la aceleración del dispositivo en los tres ejes de posición del
 dispositivo.

Por tanto, onSensorChanged toma los valores en un array de 3 float.
*/

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity(), SensorEventListener {

    // lateinit sirve para inicializar variables más tarde
    // SensorManager da acceso a los sensores del dispositivo
    private lateinit var sensorManager: SensorManager
    private var xSensor: Sensor? = null
    private var ySensor: Sensor? = null
    private var zSensor: Sensor? = null
    private var xValue by mutableStateOf("")
    private var yValue by mutableStateOf("")
    private var zValue by mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sesion4_02_3Theme {
                Scaffold() {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.height(50.dp))
                        // 2.7.- Programar que en pantalla del dispositivo se muestre en un Text de letra
                        // grande el valor medido por el sensor.
                        Text(
                            text = "Eje X: $xValue",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 24.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Eje Y: $yValue",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 24.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Eje Z: $zValue",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        xSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        ySensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        zSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    }

    override fun onResume() {
        super.onResume()
        // Registrar el listener del sensor cuando la actividad está activa
        xSensor?.let { sensor ->
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
        ySensor?.let { sensor ->
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
        zSensor?.let { sensor ->
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }

    }

    override fun onPause() {
        super.onPause()
        // Desregistrar el sensor para ahorrar batería
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            if (it.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                xValue = it.values[0].toString()
                yValue = it.values[1].toString()
                zValue = it.values[2].toString()
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
}


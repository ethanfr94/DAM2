package com.example.sesion4_02_2

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
import androidx.compose.foundation.layout.size
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
import com.example.sesion4_02_2.ui.theme.Sesion4_02_2Theme
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity(), SensorEventListener {

    // 2.3.- En la clase MainActivity declaramos tres variables miembro
    // con los objetivos indicados en los comentarios

    // lateinit sirve para inicializar variables más tarde
    // SensorManager da acceso a los sensores del dispositivo
    private lateinit var sensorManager: SensorManager
    // Variable para el Sensor de proximidad
    private var proximitySensor: Sensor? = null
    // Estado para almacenar la lectura del sensor
    private var proximityValue by mutableStateOf("No disponible")


    // 2.4.- En el método onCreate del ciclo de vida de MainActivity,
    // iniciamos los objetos sensorManager y proximitySensor.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar SensorManager
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        //obtener una instancia del sensor de proximidad
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)


        var color = Color.Black

        enableEdgeToEdge()
        setContent {
            Sesion4_02_2Theme {
                Scaffold() {
                    Column(modifier = Modifier.fillMaxSize().background(color = color)) {
                        Spacer(modifier = Modifier.height(50.dp))
                        // 2.7.- Programar que en pantalla del dispositivo se muestre en un Text de letra
                        // grande el valor medido por el sensor.
                        Text(
                            text = "Proximity Sensor: $proximityValue",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 24.sp
                        )
                        // 2.8.- Programar que cuando el sensor detecte menos de 2 cm. la pantalla
                        // se ponga en color negro y cuando detecte más de 2 cm tenga la pantalla el color rojo.
                        if(proximityValue > 2.toString()){
                            color = Color.Red
                        }else{
                            color = Color.Black
                        }
                    }


                }
            }
        }
    }

    // 2.6.- Hasta aquí todavía el sensor no enviaría datos a la app. Para se comunique
    // con MainActivity enviando datos, hay que registrarlo. Esto normalmente se hace
    // en el método onResume del ciclo de vida de la Activity (Cuando el usuario puede
    // interactuar con la pantalla).

    override fun onResume() {
        super.onResume()
        // Registrar el listener del sensor cuando la actividad está activa
        proximitySensor?.let { sensor ->
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    // 2.6.- Para que el sensor no esté consumiendo energía cuando la aplicación esté en
    // segundo plano o para que no siga activado aunque la aplicación se cierre,
    // se debe “desregistrar” el sensor en el método onPause del ciclo de vida de la Activity.

    override fun onPause() {
        super.onPause()
        // Desregistrar el sensor para ahorrar batería
        sensorManager.unregisterListener(this)
    }



    /*
    2.1.- En la declaración de la clase  MainActivity tenemos que indicar que implemente
    el interface SensorEventListener (escuchador de eventos de actualización de sensores).

    2.2.- Al implementar el interface se exigirá implementar las funciones miembro de
    ese interface

    2.5.- Programa ya el método onSensorChanged para que el valor de la variable
     proximityValue cambie cada vez que este método se ejecuta (debido a que el sensor
     notifique de un nuevo valor). Hay que tener en cuenta que ese método recibe un
     objeto evento. En un objeto evento, en el array values hay los valores medidos
     de tipo (Float). En este sensor hay un único valor en el array.
    */

    override fun onSensorChanged(event: SensorEvent?) {
        // event puede ser nulo, verifica antes de usarlo
        event?.let {
            // Actualizar el valor del sensor en la UI
            proximityValue = it.values[0].toString()
        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}


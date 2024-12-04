package com.izanfranco.sesion3_1.Vistas

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.log

@Composable
fun HomeView() {
    // variable de estado para el color de fondo de la pantalla
    var backgroundColor by remember { mutableStateOf(Color.Yellow) }
    // variable de estado del texto informativo sobre la descarga
    var downloadText by remember { mutableStateOf("Descarga no realizada") }
    // variable de estado del texto informativo sobre petición API
    var apiText by remember { mutableStateOf("sin consultar API") }
    // variable de estado para el scope de una corrutina
    val coroutineScope = rememberCoroutineScope()
    // variable de estado del texto contador
    var timerValue by remember { mutableStateOf(60) }
    // variable de estado para habilitar o deshabilitar el boton contador
    var contadorHabilitado by remember { mutableStateOf(true) }
    // variable de stado para almacenar el Job de una corrutina
    var timerJob by remember { mutableStateOf<Job?>(null) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Botón Cambiar Color
            Button(onClick = {
                backgroundColor =
                    if (backgroundColor == Color.Yellow) Color.White else Color.Yellow
            }) {
                Text("Cambiar Color")
            }

            // Botón DESCARGAR
            Button(onClick = {
                coroutineScope.launch {
                    downloadText = "Descargando......"
                    // para ver los logs abrir Logcat y filtrar por el tag en este caso "HomeView"
                    Log.d("HomeView", "Descargando......")
                    delay(10000)
                    downloadText = "Descarga completada"
                    Log.d("HomeView", "Descarga completada")
                }
            })
            {
                Text("DESCARGAR")
            }
            //Texto sobre estado de la descarga
            Text(text = downloadText)

            // Botón PETICIÓN API
            Button(onClick = {
                coroutineScope.launch {
                    apiText = "Realizando Peticion......"
                    delay(5000)
                    apiText = "Peticion completada"
                }
            })
            {
                Text("PETICIÓN API")
            }
            // Texto relacionado con estado de la petición API
            Text(text = apiText)

            // Botón CONTADOR
            Button(enabled = contadorHabilitado/*le decimos que se habilite en funcion de la variable de estado*/,
                onClick = {
                    // Cancelar la corrutina previa si existe
                    // si se pudiese volver a clicar con contador terminaria el hilo y se reiniciaria
                    timerJob?.cancel()
                    timerJob = coroutineScope.launch {
                    contadorHabilitado = false // deshabilitamos el boton
                    timerValue = 60 // inicializamos el contador
                    while (timerValue > 0){
                        delay(1000) // esperamos 1 segundo
                        timerValue-- // decrementamos el contador
                    }
                    contadorHabilitado = true// habilitamos el boton al finalizar el contador
                }
            })
            {
                Text("CONTADOR")
            }
            Text(text = timerValue.toString(),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Button(enabled = !contadorHabilitado,onClick = {
                // este boton estara habilitado cuando el contador este en marcha
                // y se deshabilitara cuando el contador termine o pulse el boton de detener
                // Cancelar la corrutina previa si existe
                // si se pudiese volver a clicar con contador terminaria el hilo y se reiniciaria
                timerJob?.cancel()
                timerJob = null
                contadorHabilitado = true
            })
            {
                Text("DETENER")
            }

            // Botón Imagenes
            Button(onClick = {

            })
            {
                Text("VER IMAGENES")
            }
        }
    }
}

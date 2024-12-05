package com.example.sesion3_02_base.views

import android.content.Intent
import android.net.Uri
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun HomeView() {
    // Estados para los TextFields
    var url by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    // context para abrir las actividades
    val context = LocalContext.current


    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp) // Espacio entre componentes
        ) {
            // TextField para la URL
            TextField(
                value = url,
                onValueChange = { url = it },
                label = { Text("Introduce la URL") },
                modifier = Modifier.fillMaxWidth()
            )

            // Botón VER WEB
            Button(
                onClick = {
                    // comprobamos si la variable url está vacía
                    if (url.isBlank()) {
                        Toast.makeText(context, "Por favor, introduce una URL.",
                            Toast.LENGTH_LONG).show()
                    } else {
                        // comprobamos si la URL tiene un formato válido
                        if (!Patterns.WEB_URL.matcher(url).matches()) {
                            Toast.makeText(
                                context, "La URL no tiene un formato válido.",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            try {
                                // Abrimos la URL en el navegador
                                // Creamos un intent con la acción ACTION_VIEW y la URL
                                // Lanzamos el intent con startActivity
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                context.startActivity(intent)
                            } catch (e: Exception) {
                                Toast.makeText(
                                    context, "No se pudo abrir la URL.",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("VER WEB")
            }

            // TextField para la latitud
            TextField(
                value = latitude,
                onValueChange = { latitude = it },
                label = { Text("Introduce la Latitud") },
                modifier = Modifier.fillMaxWidth()
            )

            // TextField para la longitud
            TextField(
                value = longitude,
                onValueChange = { longitude = it },
                label = { Text("Introduce la Longitud") },
                modifier = Modifier.fillMaxWidth()
            )

            // Botón VER MAP
            Button(
                onClick = {
                    // comprobamos si la variable latitude o longitude están vacías
                    if (latitude.isBlank() || longitude.isBlank()) {
                        Toast.makeText(context, "Por favor, introduce la latitud y longitud.",
                            Toast.LENGTH_LONG).show()
                    } else {

                        try {
                            // Covertir String a Double o nulo
                            val lat = latitude.toDoubleOrNull()
                            val lon = longitude.toDoubleOrNull()

                            // Validación de la latitud y longitud
                            if (lat == null || lon == null || lat !in -90.0..90.0 || lon !in -180.0..180.0) {
                                Toast.makeText(context,
                                    "Por favor, valores para latitud (-90 a 90) y longitud (-180 a 180).", Toast.LENGTH_LONG).show()
                            } else {
                                // Crear Intent para mostrar la ubicación en una app de mapas
                                // La URI tiene el formato geo:latitud,longitud?z=15 para abrir el mapa en una zoom de 15 (opcional)
                                val geoUri = "geo:$lat,$lon?z=15.0"
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
                                context.startActivity(intent)
                            }
                        } catch (e: Exception) {
                            Toast.makeText(context, "Error al intentar mostrar el mapa",
                                Toast.LENGTH_LONG).show()
                        }

                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("VER MAP")
            }

            // TextField para el mensaje
            TextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Escribe un mensaje") },
                modifier = Modifier.fillMaxWidth()
            )

            // TextField para el número de teléfono
            TextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Escribe un número de teléfono") },
                modifier = Modifier.fillMaxWidth()
            )

            // Botón ENVIAR A
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        //si no se le pasa el parametro sms_body, se abrirá la app de mensajes con el número de teléfono
                        //si no se le pasa el parametro smsto, se abrirá la app de mensajes pudiento seleccionar el número de teléfono
                        data = Uri.parse("smsto:$phoneNumber") // Esquema para SMS
                        putExtra("sms_body", message) // Mensaje a enviar
                    }
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("ENVIAR A")
            }

            // Botón COMPARTIR
            Button(
                onClick = {
                    /*
                            PARA ENVIAR UNA FOTO
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "image/*" // Tipo de contenido
                        putExtra(Intent.EXTRA_STREAM, Uri.parse("content://media/external/images/media/1")) // Imagen a compartir
                    }
                    val chooser = Intent.createChooser(intent, "Elige una aplicación para compartir")
                    context.startActivity(chooser)

                            PARA ENVIAR POR WHATSAPP
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain" // Tipo de contenido
                        putExtra(Intent.EXTRA_TEXT, message) // Mensaje a compartir
                            `package` = "com.whatsapp" // Especifica que sea WhatsApp
                    }
                    context.startActivity(intent)
                     */*/

                    // Crear el Intent para compartir el mensaje
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain" // Tipo de contenido
                        putExtra(Intent.EXTRA_TEXT, message) // Mensaje a compartir
                    }
                    // Crear un chooser para seleccionar la aplicación de destino
                    val chooser = Intent.createChooser(intent, "Elige una aplicación para compartir")
                    context.startActivity(chooser)

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("COMPARTIR")
            }
        }
    }
}

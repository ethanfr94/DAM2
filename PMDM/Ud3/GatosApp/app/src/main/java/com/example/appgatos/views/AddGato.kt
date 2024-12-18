package com.example.appgatos.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.appgatos.model.Gato

@Composable
fun AddGato(onDismiss: () -> Unit, onAddGato: (Gato) -> Unit) {
    var raza by remember { mutableStateOf("") }
    var origen by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = {
                if (raza.isNotEmpty() && origen.isNotEmpty()) {
                    onAddGato(
                        Gato(
                            raza = raza,
                            origen = origen,
                            urlImagen = imageUrl,
                            id = id
                        )
                    )
                }
            }) {
                Text("Agregar")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancelar")
            }
        },
        text = {
            Column {
                TextField(value = raza, onValueChange = { raza = it }, label = { Text("Raza") })
                TextField(value = origen, onValueChange = { origen = it }, label = { Text("Origen") })
                TextField(value = imageUrl, onValueChange = { imageUrl = it }, label = { Text("URL de Imagen") })
                TextField(value = id, onValueChange = { id = it }, label = { Text("ID") })
            }
        }
    )
}

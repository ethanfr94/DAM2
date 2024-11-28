package com.example.appmusica.components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appmusica.model.Encuesta

@Composable
fun EncuestaSection() {
        Column(modifier = Modifier.fillMaxWidth()) {
            var respuestaSeleccionada by remember {
                mutableStateOf<String?>(null) }
            Text(text = "valora esto", fontSize = 20.sp)
            val respuestas= listOf("bien","normal","mal")
            respuestas.forEach { respuesta ->
                Row(
                    modifier = Modifier.fillMaxWidth().height(30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = respuesta == respuestaSeleccionada,
                        onClick = {
                            respuestaSeleccionada = respuesta
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = respuesta)
                }
            }
            Button(
                onClick = { }
            ) {
                Text(text = "Enviar")
            }
        }
    }


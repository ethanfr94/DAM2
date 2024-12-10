package com.example.appmusica.views

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.appmusica.Model.Encuesta
import com.example.appmusica.Model.Reflexion
import com.example.appmusica.Model.audiosMusicales
import com.example.appmusica.Model.audiosMusicalesExt
import com.example.appmusica.Model.getReflexionDelDia
import com.example.appmusica.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ContentHomeView(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center){
        FrasedelDia()
        Spacer(modifier = Modifier.height(10.dp))
        AudioMasReciente()
        Spacer(modifier = Modifier.height(10.dp))
        EncuestaSection()
    }
}

@Composable
fun FrasedelDia(){
    // metodo que devuelve la frase del dia y su autor en funcion de la fecha
    Box(modifier = Modifier.fillMaxWidth().padding(7.dp)){
        Column (modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,){
            Text(text = "Frase del día", fontWeight = FontWeight.Bold, fontSize = 30.sp, )
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    shape = MaterialTheme.shapes.small
                )
                ){
                Column(modifier = Modifier.fillMaxWidth()){
                    Text(getReflexionDelDia().frase,overflow = TextOverflow.Ellipsis, fontStyle = FontStyle.Italic)
                    Spacer(modifier = Modifier.height(7.dp))
                    Text("- "+getReflexionDelDia().autor, modifier = Modifier.align(Alignment.End), fontWeight = FontWeight.Bold)
                }
            }
        }

    }
}
var encuestaActiva = true
@Composable
fun EncuestaSection(){
    if(encuestaActiva) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // variable para mostrar el contexto de la aplicacion
            val context = LocalContext.current
            // variable para almacenar la respuesta seleccionada
            var respuestaSeleccionada by remember { mutableStateOf<String?>(null) }
            // variable para almacenar las respuestas de la encuesta
            val respuestas = Encuesta.EncuestaHoy.respuestas
            // variable para almacenar el indice de la respuesta seleccionada
            var indice = respuestas.indexOf(respuestaSeleccionada)

            Text(text = Encuesta.EncuestaHoy.pregunta, fontSize = 20.sp)
            respuestas.forEach { respuesta ->
                Row(
                    modifier = Modifier.fillMaxWidth().height(30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = respuesta == respuestaSeleccionada,
                        onClick = {
                            respuestaSeleccionada = respuesta
                            Toast.makeText(
                                context,
                                "Has pulsado la respuesta: $respuestaSeleccionada",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = respuesta)
                }
            }
            Button(
                enabled = encuestaActiva,
                onClick = {
                    if (respuestaSeleccionada != null) {
                        indice = respuestas.indexOf(respuestaSeleccionada)
                        Toast.makeText(
                            context,
                            "Has seleccionado: $indice . $respuestaSeleccionada",
                            Toast.LENGTH_SHORT
                        ).show()
                        encuestaActiva = false
                    } else {
                        Toast.makeText(
                            context,
                            "Debes seleccionar una respuesta",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            ) {
                Text(text = "Enviar")
            }
        }
    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AudioMasReciente(){
    Box(modifier = Modifier.fillMaxWidth()){
        Column (modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalAlignment = Alignment.Start,){
            Text(text = "Audio Mas Reciente", fontWeight = FontWeight.Bold, fontSize = 30.sp, )
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    shape = MaterialTheme.shapes.medium
                )
                ){
                val audioMasReciente = audiosMusicales.maxBy { it.fecha }
                val audioMasRecienteExt = audiosMusicalesExt.maxBy { it.fecha }
                GlideImage(
                    model = audioMasRecienteExt.urlImagen,
                    contentDescription = "Imagen del audio más reciente",
                    modifier = Modifier.fillMaxSize(),   //ocupa todo el espacio disponible
                    contentScale = ContentScale.Crop,   //escalado
                    // agregado de placeholder de carga y de error (opcional)
                    //loading = placeholder(R.drawable.leon_benavente_baile_existencialista),
                    //failure = placeholder(R.drawable.archivo_error)
                )
                /*Image(
                    painter = painterResource(id = audioMasReciente.imagen),
                    contentDescription = "Imagen del audio mas reciente",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize())*/
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(50.dp)
                        .background(color = MaterialTheme.colorScheme.primary,
                            shape = MaterialTheme.shapes.large))
                {
                    Icon(
                        imageVector = Icons.Filled.PlayArrow,
                        contentDescription = "Icono del botón",
                        tint = Color.White
                    )
                }
                Text(text = audioMasReciente.titulo+" - "+audioMasReciente.artist,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart)
                        .background(Color.Yellow.copy(alpha = 0.7f)),
                    fontWeight = FontWeight.Bold)
            }
        }

    }
}
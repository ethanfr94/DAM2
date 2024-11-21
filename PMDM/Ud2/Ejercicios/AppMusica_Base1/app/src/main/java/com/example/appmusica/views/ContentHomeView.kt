package com.example.appmusica.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
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
    }
}

@Composable
fun FrasedelDia(){
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

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AudioMasReciente(){
    Box(modifier = Modifier.fillMaxWidth()){
        Column (modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalAlignment = Alignment.Start,){
            Text(text = "AudioMasReciente", fontWeight = FontWeight.Bold, fontSize = 30.sp, )
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
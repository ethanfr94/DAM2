package com.example.sesion2_09.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.sesion2_09.R
import com.example.sesion2_09.components.ImagenArtistCard
import com.example.sesion2_09.components.RetornoIconButton
import com.example.sesion2_09.data.artists
import com.example.sesion2_09.model.Artist

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(id: Int, navController: NavHostController) {
    val artist= artists.find {it.id==id }
    Scaffold(
        topBar = { TopDetailBar(onBackClick ={navController.popBackStack()})},
        content = {ContenDetailView(artist, navController)}
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopDetailBar(onBackClick: () -> Unit) {
    TopAppBar(
        title = { Text("Detalle del Artista") },
        navigationIcon = {
            RetornoIconButton (onClick = onBackClick)
        },
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
// es artist: Artist? para que pueda ser nulo
fun ContenDetailView(artist: Artist?, navController: NavHostController){
    Column (modifier = Modifier.padding(top = 20.dp)){
        // glideimage es un componente que permite cargar imagenes de internet
        // en este caso se le pasa la url de la imagen, el contenido de la imagen,
        GlideImage(
            model = artist?.imageUrl,
            contentDescription = "",
            modifier =  Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop,
            loading = placeholder(R.drawable.loading),
            failure = placeholder(R.drawable.error)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Artista: ${artist?.name}")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Ciudad: ${artist?.city} (${artist?.country})")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Estilo Musical: ${artist?.genre}")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Año de inicio: ${artist?.foundationYear}")
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "${artist?.comments}")

    }
}




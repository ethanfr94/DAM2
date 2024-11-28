package com.example.sesion2_09.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sesion2_09.components.ImagenArtistCard
import com.example.sesion2_09.model.Artist

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(artist: Artist, navController: NavController){
    Scaffold{
        ContenDetailView(navController, artist)

    }
}

@Composable
fun ContenDetailView(navController: NavController, artist: Artist){
    Column {
        ImagenArtistCard(url = artist.imageUrl, desc = "Imagen del artista")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Artista: ${artist.name}")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Ciudad: ${artist.city} (${artist.country})")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Estilo Musical: ${artist.genre}")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Año de inicio: ${artist.foundationYear}")
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "${artist.comments}")
        MainButton(name = "Return Home")
        {
            navController.popBackStack()
        }
    }
}

@Composable
fun MainButton(name: String, onClick:() -> Unit){
    Button(onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.onPrimary,
            containerColor = MaterialTheme.colorScheme.primary
        )){
        Text(text = name)
    }
}



package com.example.sesion2_09.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.sesion2_09.R
import com.example.sesion2_09.model.Artist

//Para componer ArtistCard recibe un objeto artista y una lambda
// con lo que se va a realizar cuando se pulse en Ver
@Composable
fun ArtistCard(artist: Artist, navController: NavHostController) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardColors(
            containerColor = Color.Black,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White
        ),
        shape = CardDefaults.shape,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            //Llamada a una función para pintar una imagen en Card
            ImagenArtistCard(url = artist.imageUrl,
                desc = "Imagen del artista")
            Spacer(modifier = Modifier.width(16.dp))
            // Información del artista
            InfoArtist(artist, modifier=Modifier.weight(0.75f))
            BotonCard("Ver", modifier =Modifier.weight(0.25f),artist.id,navController )
        }
    }
}

@Composable
fun BotonCard(
    texto: String,
    modifier: Modifier,
    artistId: Int,
    navController: NavHostController
) {
    // Botón "Ver"
    Text(
        textAlign = TextAlign.Right ,
        text = texto,
        color = Color.Blue,
        fontSize = 18.sp,
        fontStyle = FontStyle.Italic,
        modifier= modifier
            .clickable { navController.navigate("detail/${artistId}") }
            .padding(horizontal = 8.dp)

    )
}

@Composable
fun InfoArtist(artist: Artist, modifier: Modifier) {
    Column(
        modifier=modifier
    ) {
        Text(
            text = artist.name,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = artist.genre,
            color = Color.Gray,
            fontSize = 16.sp,
            maxLines=2
        )
    }
}

@Composable
@OptIn(ExperimentalGlideComposeApi::class)
fun ImagenArtistCard(url: String?, desc: String){
    // Imagen del artista con Glide
    GlideImage(
        model = url,
        contentDescription = desc,
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(Color.Gray),
        contentScale = ContentScale.Crop,
        loading = placeholder(R.drawable.loading),
        failure = placeholder(R.drawable.error)
    )
}

@Composable
fun RetornoIconButton(onClick:()->Unit){
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}
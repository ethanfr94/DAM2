package com.example.sesion2_09.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.sesion2_09.R
import com.example.sesion2_09.components.RetornoIconButton
import com.example.sesion2_09.data.artists
import com.example.sesion2_09.model.Artist

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailView(navController: NavHostController, id: Int) {
    val artist= artists.find {it.id==id }
    Scaffold(
        topBar = { TopDetailBar(onBackClick ={navController.popBackStack()})},
        content={ContentDetailView(navController,artist)}
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
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ContentDetailView(navController: NavHostController, artist: Artist?) {
    Column(modifier = Modifier.fillMaxSize()) {
        GlideImage(
            model = artist?.imageUrl,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop,
            loading = placeholder(R.drawable.loading),
            failure = placeholder(R.drawable.error)
        )
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .fillMaxSize()
                .padding(16.dp)
        ){
            Text(text="Artista: ${artist?.name}",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text(text="Ciudad: ${artist?.city} (${artist?.country}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text(text="Estilo musical: ${artist?.genre} ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text(text="Año de inicio: ${artist?.foundationYear} ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(32.dp))
            Text(text="${artist?.comments} ",
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

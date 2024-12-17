package com.example.sesion3_04.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.bumptech.glide.integration.compose.GlideImage
import com.example.sesion3_04.Model.Gato

@Composable
fun HomeView(navController: NavController, viewModel: GatoViewModel) {
    val gato: Gato? by viewModel.gato.observeAsState()
    LazyRow {
        items(gato) { gato ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { navController.navigate("detail/${gato.id}") }
            ) {
                Column {
                    GlideImage(
                        model = gato?.imagenURL,
                        contentDescription = "Imagen del animal extinto",
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.5f)
                    )

                    Text(text = gato.)
                }
            }
        }
    }
}


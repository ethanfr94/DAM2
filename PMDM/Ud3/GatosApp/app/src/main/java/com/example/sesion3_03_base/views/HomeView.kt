package com.example.sesion3_03_base.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.sesion3_03_base.R


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HomeView(viewModel: GatoViewModel, navController: NavController) {
    val gatos by viewModel.gatos.observeAsState(emptyList())

    var showAddGatosDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.gato),
            contentDescription = "",
            modifier = Modifier.fillMaxSize().graphicsLayer(alpha = 0.5f),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.fillMaxSize()) {
            AppBar()

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(gatos) { gato ->
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                            .fillMaxHeight(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFD0E8F2)),
                        onClick = { navController.navigate("detail/${gato.id}") }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            GlideImage(
                                model = gato.urlImagen,
                                contentDescription = "Image of ${gato.raza}",
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(CircleShape)
                                    .padding(bottom = 8.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = gato.raza,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF000000),
                                modifier = Modifier.padding(bottom = 8.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = { showAddGatosDialog = true },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Filled.AddCircle,
                contentDescription = "Añadir Gato"
            )
        }
        if (showAddGatosDialog) {
            AddGato(
                onDismiss = { showAddGatosDialog= false },
                onAddGato = { gato ->
                   viewModel.addGato(gato)
                    showAddGatosDialog = false
                }
            )
        }
    }
}

/*
@Composable
fun BotonCard(s: String, modifier: Modifier, _id: String, navController: NavController) {

    Button(
        onClick = { navController.navigate("detail/${_id}") },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFC107).copy(alpha = 0.5f) // Color dorado con transparencia
        ),
        shape = RoundedCornerShape(20.dp), // Bordes redondeados
        contentPadding = PaddingValues(5.dp) // Padding vertical para el área clickeable
    ) {
        Text(
            text = "Ver Información",
            modifier = Modifier.padding(5.dp),
            color = Color.Black, // Color del texto
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Text(
                "Razas de Gatos",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF4682B4),
            titleContentColor = Color.White
        )
    )
}

package com.example.sesion3_03_base.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.foundation.Image
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.sesion3_03_base.R
import com.example.sesion3_03_base.model.Gato


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(navController: NavController, gatoId: String, viewModel: GatoViewModel) {
    val selectedGato by viewModel.selectedGato.observeAsState()

    LaunchedEffect(gatoId) {
        viewModel.getGatoById(gatoId)
    }

    Scaffold(
        topBar = { TopDetailBar { navController.popBackStack() } },
        content = {
            if (selectedGato != null) {
                ContentDetailView(navController, selectedGato)
            } else {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopDetailBar(onBackClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                "Gato",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            RetornoIconButton(onClick = onBackClick)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF4682B4),
            titleContentColor = Color.White
        )
    )
}

@Composable
fun RetornoIconButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.White
        )
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ContentDetailView(navController: NavController, gato: Gato?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.gato),
            contentDescription = "null",
            modifier = Modifier.fillMaxSize()
                .graphicsLayer(alpha = 0.5f),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp, bottom = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                GlideImage(
                    model = gato?.urlImagen,
                    contentDescription = "Imagen de ${gato?.raza}",
                    modifier = Modifier
                        .size(300.dp)
                        .clip(CircleShape)
                        .border(4.dp, Color.Gray, CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White.copy(alpha = 0.8f))
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Column {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Raza:",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = gato?.raza ?: "Desconocida",
                            fontSize = 18.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(15.dp))

                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Origen:",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = gato?.origen ?: "Desconocido",
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(15.dp))


                }
            }
        }
    }
}


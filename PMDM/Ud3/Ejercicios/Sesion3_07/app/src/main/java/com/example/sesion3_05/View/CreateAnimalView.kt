package com.example.sesion3_05.View

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.sesion3_05.Data.Entities.Animal


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CreateAnimalView(
    homeViewModel: HomeViewModel,
    navController: NavHostController
) {
    var animal= homeViewModel.animal.observeAsState().value
    // Estados para los campos editables
    var nombreEd by remember { mutableStateOf(animal?.nombre ?: "")}
    var caracteristicasEd by remember { mutableStateOf(animal?.caracteristicas?: "") }
    var familiaIdEd by remember { mutableStateOf(animal?.familiaId.toString()?:"0") }
    var urlEd by remember { mutableStateOf(animal?.imagenUrl ?: "") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Imagen del animal (30% de la altura)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f)
        ) {
            GlideImage(
                model = urlEd,
                contentDescription = "Imagen de ${nombreEd}",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Campos editables
        TextField(
            value = nombreEd,
            onValueChange = { nombreEd = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = urlEd,
            onValueChange = { urlEd = it },
            label = { Text("url foto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = caracteristicasEd,
            onValueChange = { caracteristicasEd = it },
            label = { Text("Características") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = familiaIdEd,
            onValueChange = { familiaIdEd = it },
            label = { Text("ID de Familia") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botones para confirmar o cancelar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text(text = "Cancelar")
            }

            Button(
                onClick = {
                    val animalEd= Animal(
                        nombre = nombreEd,
                        imagenUrl = urlEd,
                        caracteristicas = caracteristicasEd,
                        familiaId = familiaIdEd.toIntOrNull() ?: 0
                    )
                    homeViewModel.insertarAnimal(animalEd)
                    navController.popBackStack()

                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text(text = "Añadir")
            }
        }
    }
}
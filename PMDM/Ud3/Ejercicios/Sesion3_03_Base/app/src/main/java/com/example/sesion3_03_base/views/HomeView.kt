package com.example.sesion3_03_base.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.sesion3_03_base.Model.Animal
import com.example.sesion3_03_base.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HomeView(viewModel: AnimalViewModel) {
    // Obtenemos el animal actual del ViewModel y lo convertimos en un estado de Compose para que se actualice la UI
    val animal: Animal? by viewModel.animal.observeAsState()
    Box{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {

            // Imagen del animal extinto
            GlideImage(
                // Si animal es null, se muestra una imagen por defecto
                model = animal?.imageSrc,
                contentDescription = "Imagen del animal extinto",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
            )
            Column(Modifier
                .fillMaxWidth()
                .weight(0.5f)){
                Spacer(modifier = Modifier.height(16.dp))

                // Nombre del animal
                Text(
                    text ="Nombre: ${animal?.commonName?:""}",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 24.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Localización
                Text(
                    text = "Localización: ${animal?.location?:""}",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 24.sp
                )

                Spacer(modifier = Modifier.height(8.dp))
                // Último registro del animal
                Text(
                    // escribimos animal?.lastRecord?:"" para que si animal es null, se muestre un string vacío
                    text = "Último registro: ${animal?.lastRecord?:""}",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 24.sp
                )
            }

        }

        // Botón "Siguiente"
        Button(
            onClick = { viewModel.getAnimalRandom() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(text = "SIGUIENTE")
        }
    }




}

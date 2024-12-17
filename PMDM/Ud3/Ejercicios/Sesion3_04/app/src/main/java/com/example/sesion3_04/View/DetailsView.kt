package com.example.sesion3_04.View

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.GlideImage
import com.example.sesion3_04.Model.Gato

@Composable
fun DetailsView(navController: NavController) {
    val gato: Gato? by viewModel.gato.observeAsState()
    Column(modifier = Modifier.padding(16.dp)) {
        GlideImage(
            model = gato?.imagenURL,
            contentDescription = "Imagen del animal extinto",
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Raza: ${gato.raza}")
        Text(text = "Origen: ${gato.origen}")
        Spacer(modifier = Modifier.height(16.dp))
        MainButton(name = "Volver") {
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
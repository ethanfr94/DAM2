package com.example.sesion3_05.View


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sesion3_05.Data.Entities.Animal

class HomeView(homeViewModel: HomeViewModel) {

    @SuppressLint("NotConstructor")
    @Composable
    fun HomeView(homeViewModel: HomeViewModel) {
        // quiero que animales se actualice con el contenido de animales de HomeViewModel
        val animales = homeViewModel.animales.observeAsState(initial = emptyList())

        LaunchedEffect(Unit) {
            homeViewModel.iniciar()
        }

        LazyColumn {
            items(animales.value.size) { index ->
                AnimalBox(
                    animal = animales.value[index],
                    onEditClick = { animalToEdit ->
                        // Acción de ejemplo para editar
                        Log.i("ROOM_PRUEBA","Editar: ${animalToEdit.nombre}") },
                    onDeleteClick = { animalToDelete ->
                        // Acción para eliminar (puedes mostrar una confirmación)
                        Log.i("ROOM_PRUEBA","Eliminar: ${animalToDelete.nombre}")
                    }
                )
            }
        }

    }

    @Composable
    fun AnimalBox(
        animal: Animal,
        onEditClick: (Animal) -> Unit,  // Callback para editar
        onDeleteClick: (Animal) -> Unit // Callback para eliminar
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.Black)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Texto del nombre del animal
            Text(
                text = animal.nombre,
                color = Color.White,
                fontSize = 30.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(0.8f)
            )

            // IconButton para editar (superpuesto en la esquina superior derecha)
            IconButton(
                onClick = { onEditClick(animal) },
                modifier = Modifier.weight(0.1f)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Editar",
                    tint = Color.White
                )
            }

            // IconButton para eliminar
            IconButton(
                onClick = { onDeleteClick(animal) },
                modifier = Modifier.weight(0.1f)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar",
                    tint = Color.White
                )
            }
        }
    }



}
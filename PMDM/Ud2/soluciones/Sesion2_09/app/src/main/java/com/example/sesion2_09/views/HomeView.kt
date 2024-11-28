package com.example.sesion2_09.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sesion2_09.components.ArtistCard
import com.example.sesion2_09.data.artists

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },

    ) { ContentHomeView(navController)}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentTopBar() {
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text(text = "Sesión 2-09") },actions = {
            // Ícono de menú
            IconButton(onClick = { expanded = true }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Menú")
            }
            // DropdownMenu en la TopAppBar
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text={Text("Opción 1")},
                    onClick = {
                        println("Opción 1 seleccionada")
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text={Text("Opción 2")},
                    onClick = {
                        println("Opción 2 seleccionada")
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text={Text("Opción 3")},
                    onClick = {
                        println("Opción 3 seleccionada")
                        expanded = false
                    }
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Composable
fun ContentHomeView(navController: NavHostController) {
    Column(modifier = Modifier.padding(8.dp)) {
        // Título
        Text(
            text = "Lista de Artistas",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
        // Lista de cardsde artistas
        LazyColumn(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            items(artists) { artista ->
                ArtistCard(artist = artista, navController=navController)
            }
        }
    }

}

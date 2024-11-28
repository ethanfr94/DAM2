package com.example.sesion2_09.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sesion2_09.views.DetailView
import com.example.sesion2_09.views.HomeView

@Composable
fun NavManager(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        // navegación a pantalla de lista de artistas
        composable("home") {
            HomeView(navController )
        }
        // navegación a pantalla de detalle, pasando un parámetro id del artista
        composable(
            route = "detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { datosNavegacion ->
            val artistId = datosNavegacion.arguments?.getInt("id") ?: 0
            DetailView(id = artistId,navController=navController)
        }
    }
}
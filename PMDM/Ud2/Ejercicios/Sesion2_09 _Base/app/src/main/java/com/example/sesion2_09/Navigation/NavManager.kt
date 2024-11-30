package com.example.sesion2_09.Navigation

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
    val navController = rememberNavController()
    // en navhost se definen las rutas de la app y se le pasa el navController para que pueda navegar entre ellas
    // startDestination es la ruta por defecto
    NavHost(navController = navController, startDestination = "HomeView") {
        composable("HomeView") {
            HomeView(navController)
        }
        composable(
            // route es la ruta de la pantalla de detalle, con un argumento id
            route = "DetailView/{id}",
            // arguments es la lista de argumentos que se pasan a la pantalla de detalle
            // en este caso, un argumento id de tipo entero
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            datosNavegacion ->
            // se obtiene el id del artista de los argumentos de navegación
            val artistId = datosNavegacion.arguments?.getInt("id") ?: 0
            // se llama a la pantalla de detalle, pasando el id del artista y el navController
            DetailView(id = artistId, navController = navController)
        }
    }
}
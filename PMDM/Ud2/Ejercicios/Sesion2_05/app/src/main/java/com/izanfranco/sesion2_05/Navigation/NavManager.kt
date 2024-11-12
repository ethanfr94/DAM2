package com.izanfranco.sesion2_03.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.izanfranco.sesion2_03.Views.DetailsView
import com.izanfranco.sesion2_03.Views.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController() // se crea el navController que se encargará de la navegación
    // en navhost se definen las rutas de la app y se le pasa el navController para que pueda navegar entre ellas
    // startDestination es la ruta por defecto
    NavHost(navController = navController, startDestination = "HomeView") { // se le pasa el navController para poder navegar entre vistas
       composable("HomeView") { // se le pasa el nombre de la ruta y la vista que se mostrará
           HomeView(navController) // se le pasa el navController para poder navegar entre vistas
       }
       /*composable("DetailsView") {
           DetailsView(navController)
       }*/
       composable("DetailsView/{id}/{user}", arguments = listOf( // se le pasa el nombre de la ruta y la vista que se mostrará
           navArgument("id") {type = NavType.IntType}, // se le pasa el tipo de dato que se espera recibir
           navArgument("user") {type = NavType.StringType}  // se le pasa el tipo de dato que se espera recibir
           )
       )
       {
           val num = it.arguments?.getInt("id")?:0 // se obtiene el valor que se le pasa a la vista por la ruta
           val user = it.arguments?.getString("user")?:"Usuario desconocido" // se obtiene el valor que se le pasa a la vista por la ruta
           DetailsView(navController,num, user) // se le pasa el navController para poder navegar entre vistas
       }
    }
}
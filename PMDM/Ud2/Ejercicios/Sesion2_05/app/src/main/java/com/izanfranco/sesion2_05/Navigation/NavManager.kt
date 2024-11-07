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
    val navController = rememberNavController()
    // en navhost se definen las rutas de la app y se le pasa el navController para que pueda navegar entre ellas
    // startDestination es la ruta por defecto
    NavHost(navController = navController, startDestination = "HomeView") {
       composable("HomeView") {
           HomeView(navController)
       }
       /*composable("DetailsView") {
           DetailsView(navController)
       }*/
       composable("DetailsView/{id}/{user}", arguments = listOf(
           navArgument("id") {type = NavType.IntType},
           navArgument("user") {type = NavType.StringType}
           )
       )
       {
           val num = it.arguments?.getInt("id")?:0
           val user = it.arguments?.getString("user")?:"Usuario desconocido"
           DetailsView(navController,num, user)
       }
    }
}
package com.example.appgatos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
//import com.example.sesion3_03_base.views.AddCharacterView
import com.example.appgatos.views.GatoViewModel
import com.example.appgatos.views.DetailView
import com.example.appgatos.views.HomeView
import com.example.appgatos.views.PrincipalView


@Composable
fun NavManager(navController: NavHostController, viewModel: GatoViewModel) {
    NavHost(
        navController = navController,
        startDestination = "principal"
    ) {
        composable("principal"){
            PrincipalView(navController)
        }
        composable("home") {
            HomeView(viewModel, navController)
        }
        composable(
            route = "detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val gatoId = backStackEntry.arguments?.getString("id") ?: ""
            DetailView(navController, gatoId, viewModel)
        }
    }
}







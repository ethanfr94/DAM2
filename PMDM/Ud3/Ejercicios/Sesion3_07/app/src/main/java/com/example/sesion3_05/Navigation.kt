package com.example.sesion3_05

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.sesion3_05.View.CreateAnimalView
import com.example.sesion3_05.View.HomeView

@Composable
fun NavManager(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "loggin"
    ) {
        composable("loggin"){
            HomeView(navController)
        }
        composable("home"){
            CreateAnimalView(navController)
        }

    }
}
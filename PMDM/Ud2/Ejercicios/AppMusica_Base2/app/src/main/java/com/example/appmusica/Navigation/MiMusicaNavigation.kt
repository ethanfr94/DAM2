package com.example.appmusica.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.appmusica.views.NavView

@Composable(NavView.Home.name){ HomeView() }
fun MiMusicaNavigation(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = NavView.Home.name)
    {

    }

}
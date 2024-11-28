package com.example.appmusica.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appmusica.model.NavView
import com.example.appmusica.views.ArtistsView
import com.example.appmusica.views.HomeView
import com.example.appmusica.views.MyAppView
import com.example.appmusica.views.PremiumView
import com.example.appmusica.views.SearchView

@Composable
fun MiMusicaNavigation(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = NavView.Home.name)
    {  //aqui asociaremos las rutas de navegación con su correspondiente View
        composable(NavView.Home.name){ HomeView() }
        composable(NavView.Artists.name){ ArtistsView() }
        composable(NavView.Search.name){ SearchView() }
        composable(NavView.MyApp.name){ MyAppView() }
        composable(NavView.Premium.name){ PremiumView() }
    }

}
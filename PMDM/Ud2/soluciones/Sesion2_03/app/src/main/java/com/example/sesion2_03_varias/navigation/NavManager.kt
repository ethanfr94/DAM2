package com.example.sesion2_03_varias.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sesion2_03_varias.models.Usuario
import com.example.sesion2_03_varias.views.DetailView
import com.example.sesion2_03_varias.views.HomeView

@Composable
fun NavManager(){
    val navController= rememberNavController()
    NavHost(navController=navController,  //asignamos val de estado
        startDestination = "Home") {   //navegacion empieza en Home
        composable("Home"){  //Ruta Home para HomeView
            HomeView(navController)
        }

        //primer parámetro de clave id y segundo parámetro String con clave user
        composable("Detail/{id}/{user}", arguments = listOf(
            navArgument("id"){type=NavType.IntType},
            navArgument("user"){type=NavType.StringType}
        )){
            val num=it.arguments?.getInt("id")?:0
            val usuario=it.arguments?.getString("user")?:"Usuario desconocido"
            DetailView(navController,num,usuario)


        }
    }
}

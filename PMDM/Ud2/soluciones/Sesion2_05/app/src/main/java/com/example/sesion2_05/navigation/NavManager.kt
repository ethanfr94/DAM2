package com.example.sesion2_05.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sesion2_05.models.grupos
import com.example.sesion2_05.views.DetallesGrupoView
import com.example.sesion2_05.views.DetallesGurupoView
import com.example.sesion2_05.views.SeleccionGrupoView

@Composable
fun NavManager(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "seleccionGrupo") {
        composable("seleccionGrupo") {
            SeleccionGrupoView(navController){ it ->
                navController.navigate("detalleGrupo/${grupoSeleccionado.}")
            }
        }
        composable(
            "detalleGrupo/{grupoId}",
            arguments = listOf(navArgument("grupoId") { type = NavType.IntType })
        ) { val grupoId = it.arguments?.getInt("grupoId")
            val grupo = grupos.find { it.id == grupoId }
            grupo?.let { DetallesGrupoView(grupo = grupo, navController = navController) }
        }
    }
}

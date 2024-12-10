package com.izanfranco.sesion2_03.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
        composable("DetailsView") {
            DetailsView(navController)
        }
    }
}

/*
* para implementar la navegacion entre pantallas debemos incluir en las dependencias del gradle de modulo:
* implementation("androidx.navigation:navigation-compose:2.6.0-alpha01")
*
* creamos la funcion NavManager que sera la encargada de gestionar la navegacion entre pantallas
*
* defiunimos la variable de estado navController que sera la encargada de gestionar la navegacion
*
* añadimos un componente navhost que sera el encargado de gestionar las rutas de la app y le pasamos el navController (variable de estado)
*  y la ruta por defecto (startDestination)
*
* añadimos las rutas de la app con el metodo composable que recibe la ruta y una funcion que se ejecutara al navegar a esa ruta
* (composable("HomeView") { HomeView(navController) })
*
* en la funcion HomeView y DetailsView se le pasa el navController (variable de estado de NavManager) como parametro para poder navegar entre pantallas
* fun HomeView(navController: NavController) {...}
*
* en la funcion ContentHomeView (y la de Detail) le pasamos el navController como parametro para poder navegar entre pantallas
* fun ContentHomeView(navController: NavController) {...}
*
* y en el onclick del MainButton (y el MainIconButton) le pasamos la funcion de navegar a la pantalla de detalle
* MainButton(name = "To Detail", onClick = { navController.navigate("DetailsView") })
*
* el texto que se le pasa al parametro de la funcion navigate es la ruta de la pantalla a la que queremos navegar y
* tendra que ser la misma que la que definimos en el navhost
*
* para que desde DetailView volvamos a homeView le pasamos la funcion popBackStack al MainIconButton
*
* en MainActivity llamamos a la funcion NavManager para que se encargue de la navegacion en lugar de llamar a HomeView
*
* */
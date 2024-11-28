package com.example.appmusica.views

import android.annotation.SuppressLint

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appmusica.model.Items_Bottom_Nav
import com.example.appmusica.navigation.MiMusicaNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MiMusicaView() {
    val navController= rememberNavController()
    Scaffold(
        topBar = { MiMusicaTopBar() },
        bottomBar = { MiMusicaBottomBar(navController=navController) },
        content = { MiMusicaNavigation(navController = navController)}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMiMusicaView() {
    MiMusicaView()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiMusicaTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Mi Musica",
                style = MaterialTheme.typography.headlineLarge
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    )
}

@Composable
private fun MiMusicaBottomBar(navController: NavHostController) {
    val bar_items= listOf(Items_Bottom_Nav.Item_bottom_nav_home,
        Items_Bottom_Nav.Item_bottom_nav_artists,
        Items_Bottom_Nav.Item_bottom_nav_search,
        Items_Bottom_Nav.Item_bottom_nav_myapp,
        Items_Bottom_Nav.Item_bottom_nav_premium)
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        bar_items.forEach { it ->
            // en clicked queda true si se ha seleccionado el botón que se está pintando
            // se está comparando la ruta del seleccionado con la ruta del botón actual
            val clicked= currentRoute( navController)==it.ruta
            //la propiedad selected se pone al valor de clicked
            NavigationBarItem(selected = clicked,
                onClick = { navController.navigate(it.ruta) },
                icon = { Icon(imageVector = it.icono, contentDescription = null)},
                label = {Text(text=it.texto)}
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController):String?=
    navController.currentBackStackEntryAsState()
        .value?.destination?.route

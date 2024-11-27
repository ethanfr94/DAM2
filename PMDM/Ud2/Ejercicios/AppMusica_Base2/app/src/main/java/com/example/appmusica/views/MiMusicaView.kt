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
import com.example.appmusica.Navigation.MiMusicaNavigation
import com.example.appmusica.model.Items_Bottom_Nav

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MiMusicaView() {

    val navController = rememberNavController()

    Scaffold(
        topBar = { MiMusicaTopBar() },
        bottomBar = { MiMusicaBottomBar(navController) },
        content = { MiMusicaNavigation(navController = navController) }
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
fun currentRoute(navController: NavHostController) :String? =
    navController.currentBackStackEntryAsState().value?.destination?.route

@Composable
private fun MiMusicaBottomBar(navController: NavHostController) {
    val bar_items = listOf(
        Items_Bottom_Nav.Item_bottom_nav_home,
        Items_Bottom_Nav.Item_bottom_nav_artists,
        Items_Bottom_Nav.Item_bottom_nav_search,
        Items_Bottom_Nav.Item_bottom_nav_myapp,
        Items_Bottom_Nav.Item_bottom_nav_premium
    )
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        bar_items.forEach {
            item ->
            val clicked = currentRoute(navController) == item.ruta
            NavigationBarItem(
                selected = clicked,
                onClick = { navController.navigate(item.ruta) },
                icon = { Icon( imageVector = item.icono, contentDescription = null)},
                label = { Text(item.texto) }
            )
        }

        /*NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = null
                )
            },
            label = {
                Text("Home")
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.List,
                    contentDescription = null
                )
            },
            label = {
                Text("Artists")
            },
            selected = false,
            onClick = {}
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null
                )
            },
            label = {
                Text("Search")
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null
                )
            },
            label = {
                Text("MyApp")
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null
                )
            },
            label = {
                Text("Premium")
            },
            selected = false,
            onClick = {}
        )*/
    }
}

package com.example.appgatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.appgatos.navigation.NavManager
import com.example.appgatos.ui.theme.GatosAppTheme
import com.example.appgatos.views.GatoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gatosViewModel: GatoViewModel by viewModels()

        setContent {
            GatosAppTheme {
                val navController = rememberNavController()
                NavManager(navController, viewModel = gatosViewModel)}
        }
    }
}


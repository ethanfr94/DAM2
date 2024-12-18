package com.example.sesion3_03_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.sesion3_03_base.navigation.NavManager
import com.example.sesion3_03_base.ui.theme.Sesion3_03_BaseTheme
import com.example.sesion3_03_base.views.GatoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gatosViewModel: GatoViewModel by viewModels()

        setContent {
            Sesion3_03_BaseTheme {
                val navController = rememberNavController()
                NavManager(navController, viewModel = gatosViewModel)}
        }
    }
}


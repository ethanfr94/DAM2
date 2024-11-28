package com.example.sesion2_09

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.sesion2_09.navigation.NavManager
import com.example.sesion2_09.ui.theme.Sesion2_09Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Sesion2_09Theme {
                val navController = rememberNavController()
                NavManager(navController)
            }
        }
    }
}



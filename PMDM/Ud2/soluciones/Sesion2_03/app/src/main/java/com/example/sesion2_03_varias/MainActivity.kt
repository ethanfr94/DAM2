package com.example.sesion2_03_varias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sesion2_03_varias.navigation.NavManager
import com.example.sesion2_03_varias.ui.theme.Sesion2_03_variasTheme
import com.example.sesion2_03_varias.views.DetailView
import com.example.sesion2_03_varias.views.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sesion2_03_variasTheme {
                NavManager()
            }
        }
    }
}


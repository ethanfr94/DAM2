package com.example.sesion2_05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sesion2_05.navigation.NavManager
import com.example.sesion2_05.ui.theme.Sesion2_03_variasTheme

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


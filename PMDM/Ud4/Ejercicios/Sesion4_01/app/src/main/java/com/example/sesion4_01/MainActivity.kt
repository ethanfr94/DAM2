package com.example.sesion4_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.sesion4_01.ui.theme.Sesion4_01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: ConnectivityViewModel by viewModels()
        setContent {
            Sesion4_01Theme {
                HomeView(viewModel)
            }
        }
    }
}


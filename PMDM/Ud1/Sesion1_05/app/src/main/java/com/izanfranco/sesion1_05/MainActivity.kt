package com.izanfranco.sesion1_05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.izanfranco.sesion1_05.ui.theme.Sesion1_05Theme
import android.util.Log

class MainActivity : ComponentActivity() {
    private var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contador++
        Log.d("Ciclo_Vida", "$contador: pasando onCreate")

        enableEdgeToEdge()
        setContent {
            Sesion1_05Theme {

            }
        }
    }

    override fun onStart() {
        super.onStart()
        contador++
        Log.d("Ciclo_Vida", "$contador: pasando onStart")
    }

    override fun onResume() {
        super.onResume()
        contador++
        Log.d("Ciclo_Vida", "$contador: pasando onResume")
    }

    override fun onPause() {
        super.onPause()
        contador++
        Log.d("Ciclo_Vida", "$contador: pasando onPause")
    }

    override fun onStop() {
        super.onStop()
        contador++
        Log.d("Ciclo_Vida", "$contador: pasando onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        contador++
        Log.d("Ciclo_Vida", "$contador: pasando onDestroy")
    }
}

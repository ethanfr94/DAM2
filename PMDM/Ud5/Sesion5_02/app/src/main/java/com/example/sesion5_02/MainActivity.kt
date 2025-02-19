package com.example.sesion5_02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sesion5_02.ui.theme.Sesion5_02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel = MediaPlayerViewModel()
        setContent {
            Sesion5_02Theme {
                HomeView(viewModel)
            }
        }
    }
}

@Composable
fun HomeView(viewModel: MediaPlayerViewModel) {
    val context = LocalContext.current
    var isPlaying by remember { mutableStateOf(false) }
    var isPaused by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Reproducción con Media Player",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.playRawAudio(context = context, rawResId = R.raw.izal)
                isPlaying = true
                isPaused = false
            },
            enabled = !isPlaying
        ) {
            Text("Archivo en Raw")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                viewModel.playAudioFile(filePath = "/storage/emulated/0/Download/izal.mp3")
                isPlaying = true
                isPaused = false
            },
            enabled = !isPlaying
        ) {
            Text("Archivo en Descargas")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                isPlaying = true
                isPaused = false

            },
            enabled = !isPlaying
        ) {
            Text("URL de Archivo")
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("URL") },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                viewModel.pauseAudio()
                isPlaying = false
                isPaused = true
            },
            enabled = isPlaying && !isPaused
        ) {
            Text("Pausar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                viewModel.resumeAudio()
                isPlaying = true
                isPaused = false
            },
            enabled = isPaused
        ) {
            Text("Reanudar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                viewModel.stopAudio()
                isPlaying = false
                isPaused = false
            },
            enabled = isPlaying || isPaused

            ) {
            Text("Parar")
        }
    }
}
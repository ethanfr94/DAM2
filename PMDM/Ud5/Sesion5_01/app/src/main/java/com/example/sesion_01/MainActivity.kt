package com.example.sesion_01

import android.annotation.SuppressLint
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sesion_01.ui.theme.Sesion_01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sesion_01Theme {
                HomeView()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceType")
@Composable
fun HomeView() {
    val context = LocalContext.current
    val soundPool = remember {
        SoundPool.Builder()
            .setMaxStreams(4)
            .setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            .build()
    }

    val soundMap = remember {
        mutableMapOf(
            //clave "bear" y valor el id del sonido cargado (un int)
            //el valor se obtiene al cargar el sonido con el método load()
            // parámetros contexto, id del archivo, y prioridad (actualmente siempre 1)
            "bear" to soundPool.load(context, R.raw.bear, 1),
            "fox" to soundPool.load(context, R.raw.fox, 1),
            "pig" to soundPool.load(context, R.raw.wild_pig, 1),
            "wolf" to soundPool.load(context, R.raw.wolf, 1)
        )
    }

    var lastStreamId by remember { mutableStateOf(0) }

    fun playSound(clave: String, volumen: Float =0.5f, loop: Int=1) {
        soundMap[clave]?.let { idSonido ->
            soundPool.play(idSonido, volumen, volumen, 1, loop, 1f)
            lastStreamId = soundPool.play(idSonido, volumen, volumen, 1, loop, 1f)
        }
    }

    fun stopLastsound(){
        //si tiene valor hacemos lo del let
        lastStreamId?.let {
            //dentro lambda let it es el valor de lastStreamId
            soundPool.stop(it)
            lastStreamId = -1
        }
    }
    //variable para crear una animación de duración infinita
    val scaleAnimation = rememberInfiniteTransition()

    // animación que cambia valores float entre 1f y 1.8f
    val scale by scaleAnimation.animateFloat(
        initialValue = 1f,
        targetValue = 1.8f,
        animationSpec = infiniteRepeatable(
            //los cambios duran 500 milisegundos a velocidad constante
            animation = tween(durationMillis = 500, easing = LinearEasing),
            //hacia adelante y hacia atrás
            repeatMode = RepeatMode.Reverse
        )
    )



    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize().padding(20.dp)){
            Column(modifier = Modifier.fillMaxSize().align(Alignment.Center)) {
                IconButton(modifier = Modifier.graphicsLayer(scaleX = scale, scaleY = scale) , onClick = {
                    playSound("bear",1f, 6)
                }) {
                    Image(
                        painter = painterResource(id = R.raw.icons8_oso_100),
                        contentDescription = "Oso"
                    )
                }
                /*Button(onClick = {
                    playSound("bear",1f, 6)

                }) {
                    Text("Oso")
                }*/
                Button(onClick = {
                    playSound("fox",1f, 3)
                }) {
                    Text("Zorro")
                }
                Button(onClick = {
                    playSound("pig",1f, 2)
                }) {
                    Text("Javali")
                }
                Button(onClick = {
                    playSound("wolf",1f, -1)

                }) {
                    Text("Lobo")
                }
                Button(onClick = {
                    soundPool.autoPause()//pausa todos los sonidos
                    //stopLastsound()// no funciona
                }) {
                    Text("Detener")
                }
            }
        }

    }
}
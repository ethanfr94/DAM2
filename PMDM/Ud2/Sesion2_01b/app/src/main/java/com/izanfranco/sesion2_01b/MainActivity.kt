package com.izanfranco.sesion2_01b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.izanfranco.sesion2_01b.ui.theme.Sesion2_01bTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sesion2_01bTheme {
                Content()
            }
        }
    }
}

val images = listOf(
    R.drawable.foto01, R.drawable.foto02, R.drawable.foto03, R.drawable.foto04, R.drawable.foto05,
    R.drawable.foto06, R.drawable.foto07, R.drawable.foto08, R.drawable.foto09, R.drawable.foto10)


@Composable
fun Content() {
    var imagen by remember { mutableStateOf(images[0]) }//Variable que almacena la imagen
    Column (
        modifier = Modifier//Modificador
            .fillMaxSize(),//Ocupa todo el tamaño
            horizontalAlignment = Alignment.CenterHorizontally//Alineación horizontal
    ){
        LazyRow(//Lista horizontal de elementos que se desplazan horizontalmente
            horizontalArrangement = Arrangement.spacedBy(10.dp),//Espacio entre elementos
            modifier = Modifier
                .fillMaxWidth()//Ocupa todo el ancho
                .padding(5.dp,30.dp,5.dp,10.dp),//Margen de 10 en los lados superior e inferior de la lista horizontal
        ) {
            items(images) { image ->
                BotonConImagen(image, onClick = { imagen = image })//Botón con imagen
            }
        }

        Caja(imagen)

    }
}

@Composable
fun Caja(imageResId: Int = R.drawable.foto01) {
    Box(modifier = Modifier
        .background(Color.LightGray)
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(10.dp),//Margen de 10
    )
    {
        Image(
            painter = painterResource(id = imageResId),//Imagen del botón
            contentDescription = null,//Descripción de la imagen
            modifier = Modifier.fillMaxSize(),//Ocupa todo el tamaño
            contentScale = ContentScale.Fit // Ajustar la imagen dentro del botón
        )
    }
}

@Composable
fun BotonConImagen(imageResId: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(100.dp) // Tamaño del botón redondo
            .clip(CircleShape) // Botón redondo
            .background(Color.LightGray)
            .clickable { onClick() } // Acción al hacer clic
    ) {
        Image(
            painter = painterResource(id = imageResId),//Imagen del botón
            contentDescription = null,//Descripción de la imagen
            modifier = Modifier.fillMaxSize(),//Ocupa todo el tamaño
            contentScale = ContentScale.Crop // Ajustar la imagen dentro del botón
        )

    }
}



//cambiar la stories de arriba por un textfield para elegir el numero de la imagen a mostrar

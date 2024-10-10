package com.izanfranco.sesion1_04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Content()

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Content(){
    Column (modifier = Modifier.fillMaxSize()){
        Area1(modifier = Modifier.weight(0.5f))
        Area2(modifier = Modifier.weight(0.2f))
        Area3(modifier = Modifier.weight(0.2f))
        Area4(modifier = Modifier.weight(0.1f))




    }
}

@Composable
fun Area1(modifier: Modifier){
    Box(
        modifier
            .fillMaxWidth()
            .background(Color(0xFFFFEB3B))
            .padding(10.dp),
        contentAlignment = Alignment.BottomEnd)
    {
       Imagen1()
        BotonFlotante(Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
fun Imagen1(){
    Image(painter = painterResource(id = R.drawable.tormenta),//imagen
        contentDescription = "tormneta",// descripcion de la imagen
        Modifier.fillMaxSize(0.5f),// tamaño de la imagen
        contentScale = ContentScale.Crop)// escala de la imagen
}


@Composable
fun BotonFlotante(modifier: Modifier){
    FloatingActionButton(onClick = { /*TODO*/ },// evento del boton
        modifier.padding(12.dp),// margen del boton
        containerColor = Color.White.copy(alpha = 0.4f),// color del boton
        contentColor = Color.Red)// color del contenido del boton
    {
        Icon(imageVector = Icons.Filled.Favorite,// icono del boton
            contentDescription = "Favorito",// descripcion del icono
            tint = Color.Red)// color del icono
    }
}

@Composable
fun Area2(modifier: Modifier){
    val imagenes = intArrayOf(R.drawable.tormenta, R.drawable.hulk, R.drawable.strange, R.drawable.catwoman, R.drawable.manhatan)
    val arraycont = arrayOf("tormenta", "hulk", "strange", "catwoman", "manhatan")
    Row(
        modifier
            .fillMaxWidth()// ancho de la fila
            .background(Color(0xFFFF8B4B))// color de fondo
            .padding(10.dp),// margen
        horizontalArrangement = Arrangement.SpaceEvenly,// distribucion de los elementos
        verticalAlignment = Alignment.CenterVertically)// alineacion vertical
    {
        for (i in 0..imagenes.size-1){
            ImagenCircular(imagenes[i], arraycont[i])
        }

    }
}

@Composable
fun ImagenCircular(img: Int, des: String) {
    Image(painter = painterResource(id = img),
        contentDescription = des,// descripcion de la imagen
        contentScale = ContentScale.Crop,// escala de la imagen
        modifier = Modifier
            .size(60.dp)// tamaño de la imagen
            .clip(CircleShape)// forma de la imagen circular
            )
}

@Composable
fun Area3(modifier: Modifier){
    Row(
        modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(16.dp)
            .background(Color(0xFFFFF8A4)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
    {
        Image(painter = painterResource(id = R.drawable.hulk),
            contentDescription = "hulk",
            modifier = Modifier
                .padding(3.dp)
                .weight(0.4f)
                .fillMaxHeight(),
            contentScale = ContentScale.Crop)
        Column (
            Modifier
                .padding(4.dp)
                .weight(0.7f))
        {
            Text("Hulk", color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
            Text("Enorme fuerza y vigor superhumanos;" +
                    "resistencia a las heridas;" +
                    "habilidad para saltar varios km de un solo impulso;", color = Color.Black,
                fontSize = 12.sp, fontStyle = FontStyle.Italic, lineHeight = 16.sp
            )
        }

    }
}



@Composable
fun Area4(modifier: Modifier){
    Row(
        modifier
            .fillMaxWidth()
            .background(Color(0xFFFFB5B3))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
    {
        Text("Area 4")

    }
}


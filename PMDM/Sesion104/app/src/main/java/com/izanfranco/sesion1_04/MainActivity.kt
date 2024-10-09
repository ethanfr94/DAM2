package com.izanfranco.sesion1_04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.izanfranco.sesion1_04.ui.theme.Sesion104Theme

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
    }
}
@Composable
fun Area2(modifier: Modifier){
    val imagenes = intArrayOf(R.drawable.tormenta, R.drawable.hulk, R.drawable.strange, R.drawable.catwoman, R.drawable.manhatan)
    val arraycont = arrayOf("tormenta", "hulk", "strange", "catwoman", "manhatan")
    Row(
        modifier
            .fillMaxWidth()
            .background(Color(0xFFFF8B4B))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly)
    {
        for (i in 0..imagenes.size-1){
            ImagenCircular(imagenes[i], arraycont[i])
        }

    }
}

@Composable
fun ImagenCircular(img: Int, des: String) {
    Image(painter = painterResource(id = img),
        contentDescription = des,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape))
}

@Composable
fun Area3(modifier: Modifier){
    Row(
        modifier
            .fillMaxWidth()
            .background(Color(0xFFFFF8A4))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
    {
        Text("Area 3")

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

@Composable
fun Imagen1(){
    Image(painter = painterResource(id = R.drawable.tormenta),
        contentDescription = "tormneta",
        Modifier.fillMaxSize(0.5f),
        contentScale = ContentScale.Crop)
}


@Composable
fun btnAccionFlotante(){
    FloatingActionButton(onClick = { /*TODO*/ },
        modifier = Modifier.align(Alignment.BottomEnd))
        {

    }
}
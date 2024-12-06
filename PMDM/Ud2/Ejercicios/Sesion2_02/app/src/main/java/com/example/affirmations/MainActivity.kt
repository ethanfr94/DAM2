/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsApp()
                }
            }
        }
    }
}

@Composable
fun AffirmationsApp() {
    val layoutDirection = LocalLayoutDirection.current
    // surface es un contenedor de nivel superior que representa la pantalla completa
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                // Agrega padding a la izquierda y derecha de la pantalla
                start = WindowInsets.safeDrawing// esta es la linea que se agrega para que el padding sea correcto
                    .asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateEndPadding(layoutDirection)
            )
    ) {
        AffirmationList(
            // carga la lista de afirmaciones
            affirmationList = Datasource().loadAffirmations()
        )
    }
}
// muestra una tarjeta de afirmación en la pantalla principal de la app
@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card (modifier = modifier) {
        Column {
            Image(
                // carga la imagen de la afirmación
                painter = painterResource(affirmation.imageResourceId),
                // describe la imagen para los usuarios con discapacidades visuales
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                // escala la imagen para que llene el ancho y la altura especificados
                contentScale = ContentScale.Crop
            )
            Text(
                // carga el texto de la afirmación
                stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .padding(16.dp),
                // establece el tamaño del texto en MaterialTheme.typography.h6
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
// muestra una vista previa de la tarjeta de afirmación
private fun AffirmationCardPreview(){
    AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image1))
}

@Composable
// crea una lista de afirmaciones y las muestra en la pantalla principal de la app
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn (modifier = modifier){
        items(affirmationList){
            affirmation ->
                AffirmationCard(
                    affirmation = affirmation,
                    modifier = Modifier.padding(8.dp))
        }
    }

}
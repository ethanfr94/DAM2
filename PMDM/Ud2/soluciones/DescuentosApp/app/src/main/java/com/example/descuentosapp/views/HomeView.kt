package com.example.descuentosapp.views


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.descuentosapp.components.Alert
import com.example.descuentosapp.components.MainButton
import com.example.descuentosapp.components.MainTextField
import com.example.descuentosapp.components.SpaceH
import com.example.descuentosapp.components.TwoCards
import com.example.descuentosapp.viewmodels.DescuentosViewModel1


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel:DescuentosViewModel1) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "App descuentos", color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) {
        ContentHomeView(it,viewModel)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues,viewModel:DescuentosViewModel1) {
    val precio:String by viewModel.precioText.observeAsState(initial="")
    val descuento:String by viewModel.descuentoText.observeAsState(initial = "")
    val precioTot:Double by viewModel.precioTot.observeAsState(initial=0.0)
    val descuentoTot:Double by viewModel.descuentoTot.observeAsState(initial = 0.0)

    val showAlert:Boolean by viewModel.showAlert.observeAsState(initial=false)
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        TwoCards(
            title1 = "Total",
            number1 = precioTot,
            title2 = "Descuento",
            number2 = descuentoTot
        )

        MainTextField(value = precio, onValueChange = {
            nuevoPrecio ->viewModel.actualizarPrecio(nuevoPrecio) },
            label = "Precio")
        SpaceH()
        MainTextField(value = descuento, onValueChange = {
            nuevoDescuento ->viewModel.actualizarDescuento(nuevoDescuento)},
            label = "Descuento %")
        SpaceH(10.dp)
        MainButton(text = "Generar descuento") {
            viewModel.generar()
        }
        SpaceH()
        MainButton(text = "Limpiar", color = Color.Red) {
            viewModel.iniciar()
        }

        if (showAlert){
            Alert(title = "Alerta",
                message = "Escribe el precio y descuento",
                confirmText = "Aceptar",
                onConfirmClick = {viewModel.desactivaAlerta() }) { }
        }

    }
}





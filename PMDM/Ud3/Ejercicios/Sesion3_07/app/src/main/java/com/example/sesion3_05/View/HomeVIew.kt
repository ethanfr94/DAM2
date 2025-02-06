package com.example.sesion3_05.View

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sesion3_05.Data.Entities.Animal

/*
2.- Crear una pantalla HomeView.kt para mostrar una lista de animales
 resultado de los que ha suministrado el ViewModel. En primer lugar,
  como siempre que usamos un ViewModel, en HomeView.kt creamos una función composable que recibe el ViewModel.
 */
@Composable
fun HomeView(homeViewModel: HomeViewModel) {

    /*
    2.1.- Agregamos un dato para consumir la lista de animales que provee el ViewModel:
     */
    // quiero que animales se actualice con el contenido de animales de HomeViewModel
    val animales = homeViewModel.animales.observeAsState(initial = emptyList())

    /*
    4.2.- En HomeView necesitamos declarar dos variables de estado para controlar el animal
    que se querrá eliminar y si el cuadro de diálogo está visible o no
    */

    // Estado para controlar la visibilidad del diálogo de eliminación
// y estado para controlar el animal a eliminar
    var animalAEliminar by remember { mutableStateOf<Animal?>(null) }
    var showDialog by remember { mutableStateOf(false) }



    /*
    2.3.- Ahora en HomeView debes crear un LazyColumn
     para representar la lista de animales usando para cada item el composable AnimalBox.
     */

    LazyColumn {
        items(animales.value.size){it ->
            AnimalBox(
                animal = animales.value[it],
                onEditClick = { animalToEdit ->
                    // Acción de ejemplo para editar
                    Log.i("ROOM_PRUEBA","Editar: ${animalToEdit.nombre}")
                },
                onDeleteClick = { animalToDelete ->
                    /*
                    4.5.- Ya por último tenemos que cambiar el código del parámetro onDeleteClick
                     en la llamada a para que active el estado de mostrar el cuadro de diálogo
                     y el estado del animal a eliminar
                    */

                    animalAEliminar = animalToDelete
                    showDialog = true
                    Log.i("ROOM_PRUEBA","Eliminar: ${animalToDelete.nombre}")
                }
            )
        }
    }

    /*
    4.4.- En la función composable HomeView debemos añadir después del LazyColumn el código para mostrar el cuadro
    de diálogo cuando la variable de estado esté a true
    */

    // Mostrar cuadro de diálogo si `showDialog` es verdadero
    if (showDialog ) {
        ConfirmDeleteDialog(
            //Confía en mi, esta variable no es nula
            animal = animalAEliminar!!,
            onConfirm = {
                homeViewModel.eliminarAnimal(it)
                showDialog = false
            },
            onDismiss = {
                showDialog = false
            }
        )
    }

    /*
      2.5.- Para que se pueda hacer un lanzamiento de la carga de los datos en la base de datos
      y de una consulta inicial, debemos llamar a la función iniciar del ViewModel dentro
      de una función LaunchedEffect que se ejecuta de forma automática dentro de una corrutina.
      Esta función debes incluirla dentro del composable HomeView.
    */

    // Llamar a la función para cargar los animales y familias inicialmente
    // Esto debería realizarse dentro de una clave segura como `LaunchedEffect`
    // para evitar múltiples llamadas
    LaunchedEffect(Unit) {
        homeViewModel.iniciar()
    }
}

/*
 2.2.- Usaremos la siguiente función composable para representar cada elemento de la lista de animales:
 */

@Composable
fun AnimalBox(
    animal: Animal,
    onEditClick: (Animal) -> Unit,  // Callback para editar
    onDeleteClick: (Animal) -> Unit // Callback para eliminar
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Black)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Texto del nombre del animal
        Text(
            text = animal.nombre,
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(0.8f)
        )

        // IconButton para editar (superpuesto en la esquina superior derecha)
        IconButton(
            onClick = { onEditClick(animal) },
            modifier = Modifier.weight(0.1f)
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Editar",
                tint = Color.White
            )
        }

        // IconButton para eliminar
        IconButton(
            onClick = { onDeleteClick(animal) },
            modifier = Modifier.weight(0.1f)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Eliminar",
                tint = Color.White
            )
        }
    }
}

/*
4.3.- En HomeView añadimos el composable para representar el cuadro de diálogo.
No explicamos el código pues ya lo vimos en otra sesión anterior. La función recibe el animal a eliminar,
la función que se realiza al confirmar y la que se realizaría al cancelar
*/

@Composable
fun ConfirmDeleteDialog(
    animal: Animal,
    onConfirm: (Animal) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            TextButton(onClick = { onConfirm(animal) }) {
                Text(text = "Aceptar")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(text = "Cancelar")
            }
        },
        title = {
            Text(text = "Confirmar eliminación")
        },
        text = {
            Text(text = "¿Estás seguro de que deseas eliminar a ${animal.nombre}?")
        }
    )
}

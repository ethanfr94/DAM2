package com.example.sesion3_05

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.example.sesion3_05.Data.Daos.FamiliaDao
import com.example.sesion3_05.Data.Database.AppDatabase
import com.example.sesion3_05.Data.Entities.Familia
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val database = DatabaseProvider.getDatabase(this)
            val familiaDao = database.familiaDao()
//Insertar los datos de una lista de familiar
            // insertarFamilias(familiaDao) comentamos para que no de error al intentar volver a introducir los datos
//Ver los datos de las familias
            verFamilias(familiaDao)

        }


    }
}

// 5_a. Crea un objeto que incluye una función que devuelve una conexión a la
//  base de datos. Al crear la conexión, se crea el fichero de base de datos, si
//  no existe aún

object DatabaseProvider {
    private var INSTANCE: AppDatabase? = null
    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "my_database.db" // Nombre a elegir
            ).build()
            INSTANCE = instance
            instance
        }
    }
}

// 5_b. Dentro del SetContent de MainACtivity (no creamos una pantalla)
//  cargamos este código para conectar con la base de datos y usar el DAO de
//  familias para añadir o insertar varias familias en la base de datos y
//  consultar después las familias cargadas.

// 5_c. Creamos ahora la función insertarFamilias que insertará las familias de
//  una lista usando el método insertFamilia de FamiliaDao. Los métodos de
//  una DAO se deben ejecutar siempre dentro de una corrutina.

@SuppressLint("SuspiciousIndentation")
private fun insertarFamilias(familiaDao: FamiliaDao) {
    val familias = listOf(
                Familia(id=1,nombre = "Cérvidos", descripcion = "Familia de los ciervos, renos y alces."),
                Familia(id=2,nombre = "Bóvidos", descripcion = "Familia de los toros, búfalos y antílopes."),
                Familia(id=3,nombre = "Mustélidos", descripcion = "Familia de los tejones, nutrias y hurones.")
        )
                CoroutineScope(Dispatchers.IO).launch {
            // Inserta cada familia en la base de datos
            familias.forEach { familia ->
                familiaDao.insertFamilia(familia)
                Log.i("ACCESO_ROOM", familia.nombre)
            }
        }
}

// 5_d. Creamos ahora la función verFamilias que obtendrá y mostrará las familias
//  existentes usando el método listAllFamiliasa de FamiliaDao.

private fun verFamilias(familiaDao: FamiliaDao) {
    var familias = emptyList<Familia>()
    CoroutineScope(Dispatchers.IO).launch {
        familias = familiaDao.getAllFamilias()
    }
    familias.forEach { familia ->
        Log.i("ACCESO_ROOM", "ID=${familia.id} Nombre=${familia.nombre}")
    }
}
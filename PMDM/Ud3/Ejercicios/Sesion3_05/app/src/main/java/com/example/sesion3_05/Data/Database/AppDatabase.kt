package com.example.sesion3_05.Data.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sesion3_05.Data.Daos.AnimalDao
import com.example.sesion3_05.Data.Daos.FamiliaDao
import com.example.sesion3_05.Data.Entities.Animal
import com.example.sesion3_05.Data.Entities.Familia

// 4. Crear la clase AppDatabase para conectar con la base de datos
// Se debe extender de RoomDatabase

@Database(
    // Se agregan la entidades
    entities = [Animal::class, Familia::class],
    // Cambiar este número si se modifica la estructura de la DB
    version = 1,
    // Cambiar a false si no se quiere exportar el esquema
    exportSchema = true
)


abstract class AppDatabase : RoomDatabase() {

    // DAOs
    abstract fun animalDao(): AnimalDao
    abstract fun familiaDao(): FamiliaDao

    // Configuraciones adicionales (opcional)

}
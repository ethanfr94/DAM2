package com.example.sesion3_05.Data.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.sesion3_05.Data.Entities.Animal

@Dao
interface AnimalDao {
    // Insertar un animal
    // Si el animal ya existe, reemplazarlo
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimal(animal: Animal): Long

    // Obtener todos los animales
    @Query("SELECT * FROM animales")
    suspend fun getAllAnimales(): List<Animal>

    // Buscar animal por ID
    @Query("SELECT * FROM animales WHERE id = :animalId")
    suspend fun getAnimalById(animalId: Int): Animal?

    // Actualizar un animal
    @Update
    suspend fun updateAnimal(animal: Animal)

    //Actualización personalizada
    @Query("UPDATE animales SET familia_id = :nuevoFamiliaId WHERE familia_id = :anteriorFamiliaId")
    suspend fun updateFamiliaIdInAnimal(anteriorFamiliaId: Int, nuevoFamiliaId: Int)

    // Eliminar un animal
    @Delete
    suspend fun deleteAnimal(animal: Animal)
}
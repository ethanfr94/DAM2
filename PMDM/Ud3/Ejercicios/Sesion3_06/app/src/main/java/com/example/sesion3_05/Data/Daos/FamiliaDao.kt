package com.example.sesion3_05.Data.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.sesion3_05.Data.Entities.Familia

@Dao
interface FamiliaDao {

    // Insertar una familia
    // Si la familia ya existe, abortar la operación
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertFamilia(familia: Familia)

    // Obtener todas las familias
    @Query("SELECT * FROM familias")
    suspend fun getAllFamilias(): List<Familia>

    // Buscar familia por ID
    @Query("SELECT * FROM familias WHERE id = :familiaId")
    suspend fun getFamiliaById(familiaId: Int): Familia?

    // Actualizar una familia
    @Update
    suspend fun updateFamilia(familia: Familia)

    // Eliminar una familia
    @Delete
    suspend fun deleteFamilia(familia: Familia)
}


package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    // onconflictstrategy.ignore ignora un elemento nuevo si ya existe uno con el mismo id
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    //suspend hace que la funcion se ejecute en un hilo secundario y no bloquee el hilo principal
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    // Flow es una secuencia de datos que emite valores de manera asincrona y continua, es decir, no se detiene hasta que se cancele
    @Query("select * from items where id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("select * from items order by name asc")
    fun getAllItems(): Flow<List<Item>>


}
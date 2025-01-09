package com.example.sesion3_05.Data.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// 3. crear entidades en data class para mapear las tablas de la base de datos

@Entity(tableName = "familias")
data class Familia(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "nom_fam")
    val nombre: String,

    @ColumnInfo(name = "desc_fam")
    val descripcion: String
)

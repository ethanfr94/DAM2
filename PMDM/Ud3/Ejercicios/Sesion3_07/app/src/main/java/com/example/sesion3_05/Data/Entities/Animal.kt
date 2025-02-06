package com.example.sesion3_05.Data.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


// el argumento foreignKeys es opcional y lo utilizamos para definir la relación entre las tablas
// especificando que familia_id es una foreign key que hace referencia a la columna id de la tabla familia
@Entity(tableName = "animales", foreignKeys =
                                    [ForeignKey(
                                        entity = Familia::class,
                                        parentColumns = ["id"],
                                        childColumns = ["familia_id"],
                                        onDelete = ForeignKey.CASCADE
                                    )]
)
data class Animal(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "nombre")
    val nombre: String = "",

    @ColumnInfo(name = "caracteristicas")
    val caracteristicas: String = "",

    @ColumnInfo(name = "imagen_url")
    val imagenUrl: String = "",

    @ColumnInfo(name = "familia_id")
    val familiaId: Int
)

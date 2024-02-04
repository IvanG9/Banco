package com.example.banco_ivpelo.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cajeros")
data class CajeroEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0, // La ID se autogenerará por Room
    var direccion: String,
    var latitud: Double,
    var longitud: Double,
    var zoom: String
)
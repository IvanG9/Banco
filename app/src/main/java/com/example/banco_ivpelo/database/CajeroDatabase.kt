package com.example.banco_ivpelo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.banco_ivpelo.dao.CajeroDAO
import com.example.banco_ivpelo.entities.CajeroEntity

@Database(entities = arrayOf(CajeroEntity::class), version = 1)
abstract class CajeroDatabase : RoomDatabase() {
    abstract fun cajeroDAO(): CajeroDAO

}
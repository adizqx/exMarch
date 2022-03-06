package com.example.exmarch.dataBase

import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.exmarch.Dao.CategoryDao
import com.example.exmarch.Dao.PlatejDao
import com.example.exmarch.Dao.UslugaDao
import com.example.exmarch.Entities.*

@Database(entities = [CategoryEntity::class, UslugaEntity::class,PlatejEntity::class], version = 1)
abstract class dataBase : RoomDatabase() {
    abstract fun Usluga(): UslugaDao
    abstract fun Platej(): PlatejDao
    abstract fun Category(): CategoryDao

}

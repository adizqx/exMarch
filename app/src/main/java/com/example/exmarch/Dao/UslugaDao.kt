package com.example.exmarch.Dao

import androidx.room.*
import com.example.exmarch.Entities.UslugaEntity

@Dao
interface UslugaDao {
    @Query("SELECT * FROM UslugaEntity")
    fun getAllUsluga(): List<UslugaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUsluga(vararg usluga: UslugaEntity)

    @Delete
    fun deleteUsluga(usluga: UslugaEntity)

    @Update
    fun updateUsluga(usluga: UslugaEntity)
}
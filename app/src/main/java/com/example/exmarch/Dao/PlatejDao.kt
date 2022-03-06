package com.example.exmarch.Dao

import androidx.room.*
import com.example.exmarch.Entities.PlatejEntity

@Dao
interface PlatejDao {
    @Query("SELECT * FROM PlatejEntity")
    fun getAllPlatej(): List<PlatejEntity>

    @Insert
    fun addPlatej(vararg platej: PlatejEntity)

    @Delete
    fun deletePlatej(platej: PlatejEntity)

    @Update
    fun updatePlatej(platej: PlatejEntity)



}
package com.example.exmarch.Dao

import androidx.room.*
import com.example.exmarch.Entities.CategoryEntity

@Dao
interface CategoryDao {

    @Query("SELECT * FROM CategoryEntity")
    fun getAllCategory(): List<CategoryEntity>

    @Insert
    fun addCategory(vararg category: CategoryEntity)

    @Delete
    fun deleteCategory(category: CategoryEntity)

    @Update
    fun updateCategory(category: CategoryEntity)
}
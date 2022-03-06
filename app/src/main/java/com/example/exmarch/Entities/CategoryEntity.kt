package com.example.exmarch.Entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class CategoryEntity(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "categoryName") var categoryName: String
): Parcelable {
    override fun toString(): String {
        return categoryName
    }
}

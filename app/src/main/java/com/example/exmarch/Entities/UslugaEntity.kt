package com.example.exmarch.Entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(
    foreignKeys = [ForeignKey(
        entity = CategoryEntity::class,
        parentColumns = ["id"],
        childColumns = ["categoryId"]
    )]
)
data class UslugaEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "uslugaName") var uslugaName: String,
    @ColumnInfo(name = "categoryId") var categoryId: Int
):Parcelable {
    override fun toString(): String {
        return uslugaName
    }
}
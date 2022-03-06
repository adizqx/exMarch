package com.example.exmarch.Entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    primaryKeys = ["categoryId", "uslugaId"],
    foreignKeys = [ForeignKey(
        entity = CategoryEntity::class,
        parentColumns = ["id"],
        childColumns = ["categoryId"]
    ),
        ForeignKey(
            entity = UslugaEntity::class,
            parentColumns = ["id"],
            childColumns = ["uslugaId"]
        )]
)
data class PlatejEntity(
    @ColumnInfo(name = "categoryId") var categoryId: Int,
    @ColumnInfo(name = "uslugaId") var uslugaId: Int    ,
    @ColumnInfo(name = "summa") var summa: Int
)


package com.example.exmarch

import android.app.Application
import androidx.room.Room
import com.example.exmarch.dataBase.dataBase


class App : Application() {

    private var database: dataBase? = null
    override fun onCreate() {
        super.onCreate()
        instance = this
        database =
            Room.databaseBuilder(this, dataBase::class.java, "database").allowMainThreadQueries().fallbackToDestructiveMigration()
                .build()

    }

    fun getDatabase(): dataBase? {
        return database
    }

    companion object {
        var instance: App? = null
    }
}

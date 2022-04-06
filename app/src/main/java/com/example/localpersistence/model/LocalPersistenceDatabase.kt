package com.example.localpersistence.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.localpersistence.model.entities.User

@Database(entities = [User::class], version = 1)
abstract class LocalPersistenceDatabase: RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: LocalPersistenceDatabase? = null

        private fun buildInstance(context: Context) = Room.databaseBuilder(
            context,
            LocalPersistenceDatabase::class.java,
            "LocalPersistenceDB")
            .build()

        fun getInstance(context: Context): LocalPersistenceDatabase = INSTANCE ?: synchronized(this){
            buildInstance(context)
        }.also {
            INSTANCE = it
        }
    }
}
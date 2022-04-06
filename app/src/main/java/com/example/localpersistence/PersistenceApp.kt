package com.example.localpersistence

import android.app.Application
import com.example.localpersistence.model.LocalPersistenceDatabase

class PersistenceApp: Application() {
    companion object{
        lateinit var application: Application private set
        val database by lazy {
            LocalPersistenceDatabase.getInstance(application)
        }
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}
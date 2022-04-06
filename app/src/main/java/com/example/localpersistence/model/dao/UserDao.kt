package com.example.localpersistence.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.localpersistence.model.entities.User

@Dao
interface UserDao {
    @Insert(onConflict = REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM Users WHERE userId = :id")
    suspend fun getById(id: Int) : User
}
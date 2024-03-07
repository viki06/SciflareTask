package com.example.sciflaretask.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.sciflaretask.model.DBModel

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<DBModel.User>

    @Query("SELECT id FROM user WHERE id = :id LIMIT 1")
    fun getUserID(id: String): String?

    @Insert
    fun insert(users: DBModel.User)

    @Update
    fun update(users: DBModel.User)

}
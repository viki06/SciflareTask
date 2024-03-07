package com.example.sciflaretask.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sciflaretask.model.DBModel

@Database(entities = [DBModel.User::class], version = 1)
abstract class UserDB : RoomDatabase()  {

    abstract fun userDao(): UserDao

}
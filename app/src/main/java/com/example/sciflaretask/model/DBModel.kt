package com.example.sciflaretask.model

import androidx.room.Entity
import androidx.room.PrimaryKey

object DBModel {

    @Entity
    data class User(
        @PrimaryKey val id: String,
        val name: String,
        val email: String,
        val mobile: String,
        val gender: String
    )

    fun fromRemoteDataList(
        userList: ArrayList<Model.User>
    ): ArrayList<User> = arrayListOf<User>().apply {
        for (user in userList)
            add(fromRemoteData(user))
    }

    private fun fromRemoteData(
        user: Model.User
    ): User = User(
        name = user.name,
        email = user.email,
        mobile = user.mobile,
        gender = user.gender,
        id = user.id
    )

}
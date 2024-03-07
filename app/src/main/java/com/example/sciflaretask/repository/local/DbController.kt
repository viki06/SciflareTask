package com.example.sciflaretask.repository.local

import com.example.sciflaretask.model.DBModel
import javax.inject.Inject

class DbController @Inject constructor(private val db: UserDB) {

    fun saveUser(userList: ArrayList<DBModel.User>) {

        for (user in userList) {

            val id = db.userDao().getUserID(user.id)

            if (id == null) {

                db.userDao().insert(users = user)

            } else {

                db.userDao().update(users = user)

            }

        }

    }

    fun getUsers(): List<DBModel.User> {

        return db.userDao().getAll()

    }


}
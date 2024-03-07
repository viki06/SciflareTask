package com.example.sciflaretask.repository

import com.example.sciflaretask.model.DBModel
import com.example.sciflaretask.model.Model
import com.example.sciflaretask.network.ApiController
import com.example.sciflaretask.repository.local.DbController
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiController: ApiController,
    private val dbController: DbController
) {

    suspend fun getUserList(): List<DBModel.User> {

        apiController.getUserList().also { userList ->

            dbController.saveUser(
                userList = DBModel.fromRemoteDataList(userList)
            )

        }

        return dbController.getUsers()

    }

    fun getLocalUserList(): List<DBModel.User> {

        return dbController.getUsers()

    }

}
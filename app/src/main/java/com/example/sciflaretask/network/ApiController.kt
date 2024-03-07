package com.example.sciflaretask.network


import com.example.sciflaretask.model.Model
import retrofit2.http.GET

interface ApiController {

    @GET("/api/e291cb9e625e43d5b0e8a785455ee534/user")
    suspend fun getUserList() : ArrayList<Model.User>

}
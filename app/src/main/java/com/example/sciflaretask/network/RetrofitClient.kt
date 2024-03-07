package com.example.sciflaretask.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASEURL = "https://crudcrud.com"

    fun getRetrofit(): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}
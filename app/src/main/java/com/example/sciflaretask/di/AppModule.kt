package com.example.sciflaretask.di

import android.app.Application
import androidx.room.Room
import com.example.sciflaretask.network.ApiController
import com.example.sciflaretask.network.RetrofitClient
import com.example.sciflaretask.repository.Repository
import com.example.sciflaretask.repository.local.DbController
import com.example.sciflaretask.repository.local.UserDB
import com.example.sciflaretask.ui.UserListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApiController(): ApiController =
        RetrofitClient.getRetrofit().create(ApiController::class.java)

    @Provides
    @Singleton
    fun provideDbController(
        application: Application
    ): DbController = DbController(
        db = Room.databaseBuilder(
            application.applicationContext,
            UserDB::class.java, "database-name"
        ).build()
    )

    @Provides
    @Singleton
    fun provideRepository(
        apiController: ApiController,
        dbController: DbController
    ): Repository = Repository(
        apiController = apiController,
        dbController = dbController
    )

    @Provides
    @Singleton
    fun provideUserListAdapter(): UserListAdapter = UserListAdapter()

}
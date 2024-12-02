package com.example.m5_l2.DI

import android.content.Context
import androidx.room.Room
import com.example.m5_l2.data.local.LoveDao
import com.example.m5_l2.data.local.LoveDataBase
import com.example.m5_l2.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoveCalculatorModule {

    @Provides
    fun getLoveApiService(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LoveDataBase {
        return Room.databaseBuilder(
            context,
            LoveDataBase::class.java,
            "love_result_database"
        )
            .build()
    }

    @Provides
    @Singleton
    fun provideLoveResultDao(database: LoveDataBase): LoveDao {
        return database.loveDao()
    }


}
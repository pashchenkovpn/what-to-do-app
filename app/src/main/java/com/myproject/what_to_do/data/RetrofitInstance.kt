package com.myproject.what_to_do.data

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://www.boredapi.com"

object RetrofitInstance {
    val usefulActivitiesApi: UsefulActivitiesApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UsefulActivitiesApi::class.java)
    }
}

interface UsefulActivitiesApi {

    @GET("/api/activity")
    suspend fun getUsefulActivityFromJson(): Response<UsefulActivityDto>
}
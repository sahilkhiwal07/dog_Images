package com.example.flickrapp.data.network

import com.example.flickrapp.data.Model.InfoDogItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.thedogapi.com/v1/breeds?x-api-key=018e70ad-32d6-4223-b2b4-6d725549bca7&q=pitbull

const val BASE_URL = "https://api.thedogapi.com/v1/"

interface LoadService {

    @GET("breeds")
    suspend fun getAllImages(
        @Query("x-api-key") api_key: String,
        @Query("q") q: String,
    ): Response<List<InfoDogItem>>

}

object LoadInfo {

    val instance: LoadService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        instance = retrofit.create(LoadService::class.java)

    }

}
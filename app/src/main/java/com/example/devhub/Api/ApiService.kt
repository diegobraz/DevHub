package com.example.devhub.Api

import com.example.devhub.model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{name}")
    suspend fun getUser(@Path("name")name:String):User

    companion object {
        var apiService: ApiService? = null
        fun getInstance() : ApiService? {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService
        }
    }

}
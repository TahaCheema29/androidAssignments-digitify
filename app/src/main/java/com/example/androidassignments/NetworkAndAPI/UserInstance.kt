package com.example.androidassignments.NetworkAndAPI

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserInstance {

    companion object{
        val BASE_URL="https://jsonplaceholder.typicode.com/"

        val retrofitInstance=Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }
}
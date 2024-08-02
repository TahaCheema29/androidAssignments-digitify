package com.example.androidassignments.NetworkAndAPI

import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("/users")
    suspend fun getUsers():Response<User>
}
package com.example.androidassignments.ArchitectureDesignPatterns.api

import com.example.androidassignments.ArchitectureDesignPatterns.ui.posts.Posts
import com.example.androidassignments.ArchitectureDesignPatterns.ui.posts.PostsItem
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.Response
import retrofit2.http.Body

interface PostAPI {
    @GET("/posts")
    suspend fun getPosts():Response<Posts>
    @POST("/posts")
    suspend fun createPost(@Body post:PostsItem):Response<PostsItem>
}
package com.example.androidassignments.ArchitectureDesignPatterns.ui.posts

import com.google.gson.annotations.SerializedName


data class PostsItem(
    @SerializedName("userId")
    val userId:Int,
    @SerializedName("id")
    val id:Int,
    @SerializedName("title")
    val title:String
)
class Posts:ArrayList<PostsItem>(
)

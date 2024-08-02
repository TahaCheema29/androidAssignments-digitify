package com.example.androidassignments.NetworkAndAPI

import com.google.gson.annotations.SerializedName

data class UserItem(
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val name:String,
    @SerializedName("email")
    val email:String,
    @SerializedName("phone")
    val phoneNum:String,
    @SerializedName("company")
    val company:Company
)
data class Company(
    @SerializedName("name")
    val name:String
)

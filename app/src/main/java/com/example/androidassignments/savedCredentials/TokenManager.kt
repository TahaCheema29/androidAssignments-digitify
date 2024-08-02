package com.example.androidassignments.savedCredentials

import android.content.Context
import com.example.androidassignments.savedCredentials.Constants.USER_DATA
import com.example.androidassignments.savedCredentials.Constants.USER_NAME
import com.example.androidassignments.savedCredentials.Constants.USER_PASS


class TokenManager(context: Context) {
    private var prefs=context.getSharedPreferences(USER_DATA,Context.MODE_PRIVATE)

    fun savedToken(userData: UserData){
        val editor=prefs.edit()
        editor.putString(USER_NAME,userData.userName)
        editor.putString(USER_PASS,userData.password)
        editor.apply()
    }

    fun getToken():UserData?{
        val userName=prefs.getString(USER_NAME,null)
        val userPass=prefs.getString(USER_PASS,null)

        return userPass?.let { pass ->
            userName?.let { name ->
                UserData(name, pass)
            }
        }
    }
}
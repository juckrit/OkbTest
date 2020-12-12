package com.example.ookbeetest.data.repository.auth.datasourceImpl

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.ookbeetest.MY_PREFS_KEY_TOKEN
import com.example.ookbeetest.MY_PREFS_NAME
import com.example.ookbeetest.data.repository.auth.datasource.AuthDatasource


class AuthDataSourceImpl(private val context: Context) :
    AuthDatasource {
    override fun saveToken(token: String) {
        val editor = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit()
        editor.putString(MY_PREFS_KEY_TOKEN, token)
        editor.apply()
    }

    override fun getToken(): String {
        val prefs: SharedPreferences = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)
        val token =
            prefs.getString(MY_PREFS_KEY_TOKEN, "") ?: ""
        return token
    }
}
package com.example.ookbeetest.data.repository.auth.datasource

interface AuthDataSource {

    fun saveToken(token:String)
    fun getToken():String
}
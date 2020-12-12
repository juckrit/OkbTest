package com.example.ookbeetest.data.repository.auth.datasource

interface AuthDatasource {

    fun saveToken(token:String)
    fun getToken():String
}
package com.example.ookbeetest.domain.repository

interface AuthRepository {
    fun saveToken(token:String)
    fun getToken():String
}
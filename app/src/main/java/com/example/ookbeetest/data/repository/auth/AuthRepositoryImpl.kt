package com.example.ookbeetest.data.repository.auth

import com.example.ookbeetest.data.repository.auth.datasourceImpl.AuthDataSourceImpl
import com.example.ookbeetest.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val authDataSourceImpl: AuthDataSourceImpl
) : AuthRepository {
    override fun saveToken(token: String) {
        authDataSourceImpl.saveToken(token)
    }

    override fun getToken(): String {
        return authDataSourceImpl.getToken()
    }
}
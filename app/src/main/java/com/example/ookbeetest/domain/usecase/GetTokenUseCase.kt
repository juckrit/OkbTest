package com.example.ookbeetest.domain.usecase

import com.example.ookbeetest.domain.repository.AuthRepository

class GetTokenUseCase(
    private val authRepository: AuthRepository
) {
    fun execute(): String {
        return authRepository.getToken()
    }
}
package com.example.ookbeetest.domain.usecase

import com.example.ookbeetest.domain.repository.AuthRepository

class SaveTokenUseCase(
    private val authRepository: AuthRepository
) {
    fun execute(token:String){
        authRepository.saveToken(token)
    }
}
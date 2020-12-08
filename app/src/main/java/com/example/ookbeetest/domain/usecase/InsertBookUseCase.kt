package com.example.ookbeetest.domain.usecase

import com.example.ookbeetest.data.model.InsertUserBookReponseModel
import com.example.ookbeetest.data.model.InsertUserBookRequestModel
import com.example.ookbeetest.domain.repository.BookRepository

class InsertBookUseCase(
    private val bookRepository: BookRepository
) {
    suspend fun execute(
        accessToken: String
        , userId: Int
        , insertUserBookRequestModel: InsertUserBookRequestModel
    ): List<InsertUserBookReponseModel> {
        return bookRepository.insertUserBook(accessToken, userId, insertUserBookRequestModel)
    }
}
package com.example.ookbeetest.domain.repository

import com.example.ookbeetest.data.model.InsertUserBookReponseModel
import com.example.ookbeetest.data.model.InsertUserBookRequestModel

interface BookRepository {
    suspend fun insertUserBook(
        accessToken: String
        , userId: Int
        , insertUserBookRequestModel: InsertUserBookRequestModel
    ): List<InsertUserBookReponseModel>
}
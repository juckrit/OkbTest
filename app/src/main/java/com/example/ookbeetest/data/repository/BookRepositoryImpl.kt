package com.example.ookbeetest.data.repository

import com.example.ookbeetest.data.model.InsertUserBookReponseModel
import com.example.ookbeetest.data.model.InsertUserBookRequestModel
import com.example.ookbeetest.data.repository.datasourceImpl.BookRemoteDataSourceImpl
import com.example.ookbeetest.domain.repository.BookRepository

class BookRepositoryImpl(
    private val bookRemoteDataSourceImpl: BookRemoteDataSourceImpl
) : BookRepository {

    override suspend fun insertUserBook(
        accessToken: String,
        userId: Int,
        insertUserBookRequestModel: InsertUserBookRequestModel
    ): List<InsertUserBookReponseModel> {
        return bookRemoteDataSourceImpl.insertBookToServer(userId, insertUserBookRequestModel)
    }
}
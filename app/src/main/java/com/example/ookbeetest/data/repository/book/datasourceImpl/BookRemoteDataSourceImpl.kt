package com.example.ookbeetest.data.repository.book.datasourceImpl

import com.example.ookbeetest.data.api.OokBeeService
import com.example.ookbeetest.data.model.InsertUserBookReponseModel
import com.example.ookbeetest.data.model.InsertUserBookRequestModel
import com.example.ookbeetest.data.repository.book.datasource.BookRemoteDataSource

class BookRemoteDataSourceImpl(
    private val ookBeeService: OokBeeService
) : BookRemoteDataSource {

    override suspend fun insertBookToServer(
        userId: Int,
        book: InsertUserBookRequestModel,
        authorizationKey: String
    ): List<InsertUserBookReponseModel> {
        return ookBeeService.insertUserBook(authorizationKey, userId, book)
    }
}
package com.example.ookbeetest.data.repository.datasourceImpl

import com.example.ookbeetest.data.api.OokBeeService
import com.example.ookbeetest.data.model.InsertUserBookReponseModel
import com.example.ookbeetest.data.model.InsertUserBookRequestModel
import com.example.ookbeetest.data.repository.datasource.BookRemoteDataSource

class BookRemoteDataSourceImpl(
    private val ookBeeService: OokBeeService, private val authorizationKey: String
) : BookRemoteDataSource {

    override suspend fun insertBookToServer(
        userId: Int,
        book: InsertUserBookRequestModel
    ): List<InsertUserBookReponseModel> {
        return ookBeeService.insertUserBook(authorizationKey, userId, book)
    }
}
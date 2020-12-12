package com.example.ookbeetest.data.repository.book.datasource

import com.example.ookbeetest.data.model.InsertUserBookReponseModel
import com.example.ookbeetest.data.model.InsertUserBookRequestModel

interface BookRemoteDataSource {
    suspend fun insertBookToServer(userId:Int,book: InsertUserBookRequestModel,authorizationKey: String):List<InsertUserBookReponseModel>
}
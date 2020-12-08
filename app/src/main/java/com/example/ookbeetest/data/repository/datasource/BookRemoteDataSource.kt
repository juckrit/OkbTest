package com.example.ookbeetest.data.repository.datasource

import com.example.ookbeetest.data.model.InsertUserBookReponseModel
import com.example.ookbeetest.data.model.InsertUserBookRequestModel

interface BookRemoteDataSource {
    suspend fun insertBookToServer(userId:Int,book: InsertUserBookRequestModel):List<InsertUserBookReponseModel>
}
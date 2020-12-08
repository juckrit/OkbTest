package com.example.ookbeetest.data.api

import com.example.ookbeetest.data.model.InsertUserBookReponseModel
import com.example.ookbeetest.data.model.InsertUserBookRequestModel
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface OokBeeService {

//    Method: POST
//    URL: http://api.ookbee.com/user/{userId}/books
//    Parameter:
//    Name		Parameter Type		Data Type
//    Authorization	header			String
//    userId		path			Int
//    bookId		body			Int
//    bookName	body			String
//    bookAuthor	body			String
//    bookPrice	body			Double

    @POST("{userId}/books")
    suspend fun insertUserBook(
        @Header("Authorization") accessToken: String
        , @Path("userId") userId: Int
        , @Body insertUserBookRequestModel: InsertUserBookRequestModel
    ): List<InsertUserBookReponseModel>

    companion object {
        val instance: OokBeeService by lazy {
            Retrofit.Builder().baseUrl(BASE_USER_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
                .create(OokBeeService::class.java)
        }

        private val client = OkHttpClient().newBuilder()
//            .addInterceptor(TokenExpiredInterceptor())
            .build()
    }

}
package com.example.ookbeetest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class InsertUserBookReponseModel(
    @SerializedName("bookId") @Expose val bookId: Int,
    @SerializedName("bookName") @Expose val bookName: String,
    @SerializedName("bookAuthor") @Expose val bookAuthor: String,
    @SerializedName("bookPrice") @Expose val bookPrice: Double
)

data class InsertUserBookRequestModel(
    @SerializedName("bookId") @Expose val bookId: Int,
    @SerializedName("bookName") @Expose val bookName: String,
    @SerializedName("bookAuthor") @Expose val bookAuthor: String,
    @SerializedName("bookPrice") @Expose val bookPrice: Double
)



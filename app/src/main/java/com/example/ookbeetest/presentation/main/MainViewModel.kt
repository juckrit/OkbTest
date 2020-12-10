package com.example.ookbeetest.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ookbeetest.FAILURE
import com.example.ookbeetest.NO_INTERNET_CONNECTION
import com.example.ookbeetest.data.model.InsertUserBookReponseModel
import com.example.ookbeetest.data.model.InsertUserBookRequestModel
import com.example.ookbeetest.data.model.ResultWrapper
import com.example.ookbeetest.domain.usecase.InsertBookUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class MainViewModel(
    private val insertBookUseCase: InsertBookUseCase
) : ViewModel() {

    private val insertBookResultLiveData = MutableLiveData<ResultWrapper<List<InsertUserBookReponseModel>>>()
    private var mBookId = 0
    private var mBookName = ""
    private var mBookAuthur = ""
    private var mBookPrice = 0.0

    fun getInsertBookResultLiveData(): MutableLiveData<ResultWrapper<List<InsertUserBookReponseModel>>> {
        return insertBookResultLiveData
    }

    fun getAccessToken(): String {
        return "mytoken"
    }

    fun getUserId(): Int {
        return 1
    }

    fun setBookId(bookId:Int){
        this.mBookId = bookId
    }

    fun setBookName(name:String){
        this.mBookName = name
    }

    fun setBookAuthur(authurName:String){
        this.mBookAuthur = authurName
    }

    fun setBookPrice (price:Double){
        this.mBookPrice = price
    }

    fun createModel(): InsertUserBookRequestModel {
        val model = InsertUserBookRequestModel(mBookId,mBookName,mBookAuthur,mBookPrice)
        return model
    }

    fun insertBook() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = insertBookUseCase.execute(getAccessToken(), getUserId(), createModel())
                if (response != null) {
                    // success
                    insertBookResultLiveData.postValue(ResultWrapper.Success(response))
                } else {
                    //Fail
                    insertBookResultLiveData.postValue(ResultWrapper.Error(FAILURE,null))
                }
            } catch (e: IOException) {
                insertBookResultLiveData.postValue(ResultWrapper.Error(e.message ?: "",e))

            } catch (e: Exception) {
                insertBookResultLiveData.postValue(ResultWrapper.Error(FAILURE,e))

            }
        }
    }
}
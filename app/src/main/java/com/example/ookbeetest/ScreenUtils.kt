package com.example.ookbeetest

import android.content.Context
import android.widget.Toast

object ScreenUtils {

    fun showToast(context: Context,text:String){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
    }
}
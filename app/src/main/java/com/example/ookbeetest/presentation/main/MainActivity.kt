package com.example.ookbeetest.presentation.main

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.ookbeetest.R
import com.example.ookbeetest.ScreenUtils
import com.example.ookbeetest.data.model.ResultWrapper
import com.example.ookbeetest.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import java.lang.Exception


/*
    Android Developer Quiz
    ข้อแนะนำ
	•	การตอบคำถาม ขอให้ตอบด้วย code ที่น่าจะใช้ได้ในการทำงานจริง
	•	การพิจารณาจะพิจารณาจากความเหมาะสมและความถูกต้องของผลลัพธ์ในการใช้งานในทางปฎิบัติ
	•	คำถามข้อใดไม่มั่นใจ ขอให้ทำเท่าที่ทำได้
	•	ข้อใดทำไม่ได้เลยให้เว้นไว้
	•	สามารถเขียนหมายเหตุในคำตอบได้ตามที่เห็นสมควร

	Code ข้อ 1-3 อยู่ใน Folder Test ครับ
	ข้อสุดท้าย ก็ทั้งโปรเจคครับ
 */

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by inject()
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        observe()

        binding.btnSend.setOnClickListener {
            try {
                mainViewModel.setBookId(binding.etBookId.text.toString().toInt())
                mainViewModel.setBookName(binding.etBookName.text.toString())
                mainViewModel.setBookAuthur(binding.etBookAuthur.text.toString())
                mainViewModel.setBookPrice(binding.etBookPrice.text.toString().toDouble())
            }catch (e:Exception){

            }
            postBookToServer()
        }





        ScreenUtils.showToast(
            this,
            "Code ข้อ 1-3 อยู่ใน Folder Test-question ครับ"
        )


        //ข้อสุดท้าย ก็ทั้งโปรเจคครับ
//        •	จงเขียน function ในภาษา Java ด้วย Android SDK ในลักษณะ Asynchronous function ในการเพิ่มข้อมูลหนังสือผ่าน Web API ตามรายละเอียดดังนี้
//
//        Method: POST
//        URL: http://api.ookbee.com/user/{userId}/books
//        Parameter:
//        Name		Parameter Type		Data Type
//        Authorization	header			String
//        userId		path			Int
//        bookId		body			Int
//        bookName	body			String
//        bookAuthor	body			String
//        bookPrice	body			Double
//        Response Model:
//        [
//            {
//                “bookId” : 0,
//                “bookName” : “String”,
//                “bookAuthor”: “String”,
//                “bookPrice” : 0.0
//            },
//        …
//        ]
//
//        หมายเหตุ: สามารถนิยาม method signature ได้ตามเห็นสมควร และถ้ามีการใช้ Third-party libraries นอกเหนือจาก Standard ที่มีใน Android SDK กรุณาระบุชื่อ Library ดังกล่าว และเหตุผลที่ต้องใช้ Library ดังกล่าว


//        คำตอบ:
//        [ใส่คำตอบตรงนี้]
        //Third-party libraries ดูจาก gradle ได้เลยครับ
        //หลักๆก็พวก retrofit coroutine

    }

    private fun postBookToServer() {
        mainViewModel.insertBook()
    }

    private fun observe() {
        mainViewModel.getInsertBookResultLiveData().observe(this, Observer {
            when (it) {
                is ResultWrapper.Success -> {
                    AlertDialog.Builder(this)
                        .setTitle("Success")
                        .setMessage("Success")
                        .setCancelable(false)
                        .setPositiveButton("ok", object : DialogInterface.OnClickListener {
                            override fun onClick(dialog: DialogInterface?, which: Int) {
                                dialog?.dismiss()
                            }
                        }).show()
                }
                is ResultWrapper.Error -> {
                    AlertDialog.Builder(this)
                        .setTitle("Fail")
                        .setMessage(it.message)
                        .setCancelable(false)
                        .setPositiveButton("ok", object : DialogInterface.OnClickListener {
                            override fun onClick(dialog: DialogInterface?, which: Int) {
                                dialog?.dismiss()
                            }
                        }).show()
                }
            }
        })
    }


}
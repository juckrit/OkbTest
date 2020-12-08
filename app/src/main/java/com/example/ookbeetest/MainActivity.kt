package com.example.ookbeetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ScreenUtils.showToast(this,"Code ข้อ 1-3 อยู่ใน Folder Test ครับ")


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


}
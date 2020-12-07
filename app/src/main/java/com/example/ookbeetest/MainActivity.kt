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

	Code อยู่ใน Folder Test ครับ
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ScreenUtils.showToast(this,"Code อยู่ใน Folder Test ครับ")

    }


}
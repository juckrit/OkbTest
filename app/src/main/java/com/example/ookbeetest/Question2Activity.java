package com.example.ookbeetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Question2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
    }

    @Override
    protected void onResume() {
        super.onResume();

//        จงเขียน function ในภาษา Java ที่รับ string ที่เป็นช่วงของวันที่ 2 ช่วง
//        และ return boolean ที่บอกว่า
//        ช่วงเวลาทั้งสองช่วง มีวันซ้อนทับกันหรือไม่
//        โดยให้สมมติว่า string ของวันที่จะอยู่ในรูปแบบ
//        “yyyymmdd” เสมอ และให้มี signature ดังนี้
//        boolean IsOverlapped(String start1, String end1, String start2, String end2) 


        //อันนี้ผมเข้าใจว่า โจทย์น่าจะหมายถึง yyyyMMdd
        //ซึ่งแปลว่า
        //yyyy year เช่น 2018(yyyy),18(yy)
        //MM Month in year เช่น July(MMMM), Jul(MMM), 07(MM)
        //dd Day of the month เช่น 09(dd), 9(d)

        //หากเปน yyyymmdd
        //ที่หมายถึง
        //yyyy year
        //mm Minute in the hour
        //dd Day of the month
        //ผมคงทำไม่ได้ เพราะงั้นผมจะตอบในรูปแบบของ yyyyMMdd


        String start1Str="20201207";
        String end1Str="20201214";
        String start2Str="20201215";
        String end2Str="20201230";
        Date start1 = null;
        Date end1 = null;
        Date start2 = null;
        Date end2 = null;
        try {
            start1 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(start1Str);
            end1 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(start1Str);
            start2 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(start1Str);
            end2 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(start1Str);
        } catch (ParseException e) {
            e.printStackTrace();
        }


//        String start1Str="20201207";
//        String end1Str="20201214";
//        String start2Str="20201215";
//        String end2Str="20201230";
//        Date start1 = null;
//        Date end1 = null;
//        Date start2 = null;
//        Date end2 = null;
        try {
            start1 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(start1Str);
            end1 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(start1Str);
            start2 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(start1Str);
            end2 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(start1Str);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        if (isOverlapping(start1,end1,start2,end2)){
            ScreenUtils.INSTANCE.showToast(this,"Overlapping");
        }else {
            ScreenUtils.INSTANCE.showToast(this,"Not Overlapping");
        }


    }



    public boolean isOverlapping(Date start1, Date end1, Date start2, Date end2) {
        return start1.before(end2) && start2.before(end1);
    }
}
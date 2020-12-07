package com.example.ookbeetest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Question2Test {

    @Test
    public void question2_1_NotOverlapped() {
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


        //Not Overlapped
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
            end1 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(end1Str);
            start2 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(start2Str);
            end2 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(end2Str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assertFalse(isOverlapping(start1,end1,start2,end2));

    }

    @Test
    public void question2_2_Overlapped(){
        //Overlapped
        String start3Str="20201207";
        String end3Str="20201214";
        String start4Str="20201208";
        String end4Str="20201230";
        Date start3 = null;
        Date end3 = null;
        Date start4 = null;
        Date end4 = null;
        try {
            start3 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(start3Str);
            end3 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(end3Str);
            start4 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(start4Str);
            end4 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(end4Str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertTrue(isOverlapping(start3,end3,start4,end4));


    }


    public boolean isOverlapping(Date start1, Date end1, Date start2, Date end2) {
        return start1.before(end2) && start2.before(end1);
    }




}

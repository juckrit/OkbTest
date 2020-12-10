package com.example.ookbeetest.question;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Question1Test {

    @Test
    public void question1() {

        //        •	จงแสดงผลลัพธ์ของ Code ดังต่อไปนี้ พร้อมอธิบายเหตุผล
//        String s1 = new String("Test");
//        String s2 = new String("Test");
//        if (s1==s2)
//            System.out.println("Same");
//        if (s1.equals(s2))
//            System.out.println("Equals");
//
//        คำตอบ:
//        [ใส่คำตอบตรงนี้]

        boolean isSame = false;
        boolean isEquals = false;
        String s1 = new String("Test");
        String s2 = new String("Test");
        if (s1 == s2) {
            System.out.println("Same");
            isSame = true;
        }
        if (s1.equals(s2)){
            System.out.println("Equals");
            isEquals = true;
        }


//        ตอบ
//        1 ไม่ Same เพราะมันมองว่าเปนคนละ Address กัน คือว่า ตอนนี้มันสร้าง instance s1 มันก็จะไปจองพื้นที่บน ram ไว้ 1 พื้นที่
//          แล้วพอมันสร้าง s2 มันก็จะไปจองไว้อีก 1 พื้นที่ ที่นี่ พอใช้คำสั่ง == มันหมายถึงว่า เอาตำแหน่งที่จองไว้ในหน่อยความจำมาเทียบกัน
//          ว่ามันเปนตำแหน่งเดียวกันหรือป่าว คำตอบคือ ไม่ใช่ตำแหน่งเดียวกัน
//        2 Equals เพราะ equals คือการถามว่าอักขระทุกตัวเหมือนกันทุกประการหรือไม่โดยสนใจตัวเล็กตัวใหญ่ด้วย คำตอบคือ เหมือนกันทุกประการ
//            แต่ถ้าไม่สนใจตัวเล็กตัวใหญ่ต้องใช้ equalsIgnoreCase


        assertFalse(isSame);
        assertTrue(isEquals);
    }
}

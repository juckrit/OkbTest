package com.example.ookbeetest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Question3Test {

    @Test
    public void question3() {
//        จงเขียน function ในภาษา Java ที่ return ค่าสูงสุด 2 อันดับแรก
//        จาก array ที่ให้ โดยไม่ใช้การเรียง และมีค่า Big-O complexity เป็น O(n)
//        โดยให้มี method signature ดังนี้  int[] GetMaxTwo(int[] numbers) 
//        ตัวอย่างข้อมูล: [1,8,2,6,5,3,5,0]	ผลลัพธ์ที่ต้องการ: [8,6]
//         คำตอบ:
//        [ใส่คำตอบตรงนี้]

        int[] array = new int[]{1, 8, 2, 6, 5, 3, 5, 0};

        assertEquals(8, GetMaxTwo(array)[0]);
        assertEquals(6, GetMaxTwo(array)[1]);

    }


    public static int[] GetMaxTwo(int[] numbers)
    {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int value:numbers)
        {
            if (value > max)
            {
                secondMax = max;
                max = value;
            }
            else if (value > secondMax && value < max)
            {
                secondMax = value;
            }
        }
        return new int[] { max, secondMax };
    }

}

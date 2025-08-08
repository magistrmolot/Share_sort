package org.example;


import java.util.Arrays;
import java.util.Random;

public class App
{
    public static void main( String[] args )
    {
        Random r = new Random();
        int t = 300000;
        int[] testArr = new int[t];


        for (int i = 0; i < t; i++) {
            testArr[i] = r.nextInt(t);
        }
//        System.out.println(Arrays.toString(testArr));

        testArr = ShareSort.shareSort(testArr);


    }
}

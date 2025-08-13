package org.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShareSortTest {
    @Test
    @DisplayName("Cheked Array Sort")
    void testContainElemets(){
        int [] arr = {2,5,3,4};
        int [] sort = {2,3,4,5};
        bodyTestShareSort(arr,sort);
        arr = new int[]  {};
        sort = new int[] {};
        bodyTestShareSort(arr,sort);
        arr = new int[]  {2};
        sort = new int[] {2};
        bodyTestShareSort(arr,sort);
        arr = new int[]  {2,1};
        sort = new int[] {1,2};
        bodyTestShareSort(arr,sort);
    }


    void bodyTestShareSort(int [] arr, int [] sort){
    arr = ShareSort.shareSort(arr);
    assertArrayEquals(sort,arr);

    }
}

package org.example;

import java.util.Arrays;
import java.util.Random;

public class ShareSort {

    public static void main( String[] args )
    {
        Random r = new Random();
        int t = 2000000;
        int[] testArr = new int[t];


        for (int i = 0; i < t; i++) {
            testArr[i] = r.nextInt(t);
        }
//       System.out.println(Arrays.toString(testArr));

        testArr = ShareSort.shareSort(testArr);

//       System.out.println(Arrays.toString(testArr));
    }

    public static int [] shareSort(int[] arr){
        if(arr.length == 0){
            System.out.println("Элементы в массиве отстутствуют");
            return arr;
        }else if(arr.length == 1){
            System.out.println("Нечего соритировать в массиве 1 элемент");
            return arr;
        }else if(arr.length == 2){
            if(arr[0] > arr[1]){
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            }
            return arr;
        }
        arr = shareDoSort(arr);
        return arr;
    }

    public static int [] shareDoSort(int[] arr){
        int startArr = 0;
        int endArr = arr.length-1;
        int from = startArr;
        int from2 = 0;
        int to = endArr;
        int [] bufArr;
        int [] setArr = new int[arr.length];
        int [] sortArr= new int[0];

        while(from+1 < to){
            //Выход из цикла если большего элемента в правой части нет
            while (from + 1 < to) {
                //Переходим к следующему эленту массива если он больше чем предедущий
                if (arr[from] <= arr[from + 1]) {
                    from++;
                    //Ищем больший элемент массива если следущий элемент меньше предедущего
                } else if (from + 1 < to )  {
                    //Поиск большего элемента в левой части
                    while (arr[from] > arr[to] && from + 1 < to ) {
                        to--;
                    }
                    //Перестановка большего найденого элемента
                    if (arr[from] <= arr[to] && from + 1 < to) {
                        int temp = arr[from + 1];
                        arr[from + 1] = arr[to];
                        arr[to] = temp;
                    }
                    from++;
                }
            }
            //Устранение колизии
            if(from != to){
                from++;
            }

            //Возрат в начало правой части
            to = endArr;

            //Копирование отсортированой части в отдельный массив
            bufArr = Arrays.copyOfRange(arr,from2,from);

            int i = 0;
            int j = 0;
            int c = 0;
            //Слияние массивов в отсоритрованый масив
            while(j <= sortArr.length-1 && c <= bufArr.length-1)
                setArr[i++] = bufArr[c] > sortArr[j] ? sortArr[j++] : bufArr[c++];

            while(j >= sortArr.length-1 && c <= bufArr.length-1)
                setArr[i++] = bufArr[c++];

            while(j <= sortArr.length-1 && c >= bufArr.length-1)
                setArr[i++] = sortArr[j++];

            sortArr = Arrays.copyOfRange(setArr,0,from);

            from2 = from;
        }

        int i = 0;
        int j = 0;
        int c = 0;
        //Копирование остатка в отдельный массив
        bufArr = Arrays.copyOfRange(arr,from,endArr+1);

        //Если в остатке больше 1 элемента сорутируем
        //Больше 2 элементов не пока не было
            int v = 0;
            while (v + 1 < bufArr.length) {
                if (bufArr[v] > bufArr[v + 1]) {
                    int temp = bufArr[v];
                    bufArr[v] = bufArr[v + 1];
                    bufArr[v + 1] = temp;
                }
                v++;

        }
            //Сливаем остаток в общий массив
            while(j <= sortArr.length-1 && c <= bufArr.length-1)
                setArr[i++] = bufArr[c] > sortArr[j] ? sortArr[j++] : bufArr[c++];

            while(j >= sortArr.length-1 && c <= bufArr.length-1)
                setArr[i++] = bufArr[c++];

            while(j <= sortArr.length-1 && c >= bufArr.length-1)
                setArr[i++] = sortArr[j++];

            //Возращаем массив
            return setArr;
    }

}

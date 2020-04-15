package com.xkz.jvmdemo;

public class fjkDemo {
    public static void main(String[] args){
        final int[] array={1,2,3,4,5};
        array[3] = 100;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println(check(7,6));
    }
    public static boolean check(int a,int b){
        
        int max = Math.max(a,b);
        if(max > 5){
            return true;
        }else {
            return false;
        }
    }
    public static void bubbleSort(int[] arr) {
        int temp;
        // 做多少轮排序（最多length-1轮）
        for (int i = 0; i < arr.length - 1; i++) {
            // 每一轮比较多少个
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换次序
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}

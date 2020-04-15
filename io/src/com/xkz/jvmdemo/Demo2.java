package com.xkz.jvmdemo;

/**
 * 演示内存溢出
 */
public class Demo2 {
    public static int count;

    public static void main(String[] args){
        try {
            method1();
        } catch(Throwable e){
            e.printStackTrace();
            System.out.println(count);
        }
    }
    private static void method1(){
        count++;
        method1();
    }
}

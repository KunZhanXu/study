package com.xkz.jvmdemo;

public class Demo1 {
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer();
        sb.append(4);
        sb.append(5);
        sb.append(6);
        new Thread(()->{
            m2(sb);
        }).start();
    }
    public static void m1() {
        StringBuffer sb = new StringBuffer();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }
    public static void m2(StringBuffer sb) {
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }
    public static StringBuffer m3() {
        StringBuffer sb = new StringBuffer();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        return sb;
    }
}

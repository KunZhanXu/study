package com.xkz.jvmdemo;

public class Demo5 {
    public static void main(String[] args){
        String s = new String("a" ) + new String("b");

        String s2 = s.intern();

        System.out.println(s2 == "ab");
        System.out.println(s == "ab");
    }
}

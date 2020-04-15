package com.xkz.jvmdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示StringTable 位置
 * 在jdk8设置下 -Xmx10m -XX:-UseGcOverheadLimit
 * 在jdk6设置下 -XX:MaxPermSize=10m
 */
public class JvmDemo6 {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        int i = 0;
        try {
            for(int j = 0; j<260000; j++){
                System.out.println(String.valueOf(j));
                list.add(String.valueOf(j).intern());  //intern 将常量池中的元素放入串池中
                i++;
            }
        }catch (Throwable e){
            e.printStackTrace();
        } finally{
            System.out.println(i);
        }
    }
}

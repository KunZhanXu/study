package com.xkz.jvmdemo;


/**
 * 演示StringTable 垃圾回收
 * -Xmx10m  -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 * (-Xmx10m：设置虚拟机堆内存最大值)
 * PrintStringTableStatistics打印字符串表的统计信息
 * -XX:+PrintGCDetails -verbose:gc 打印垃圾回收的相关信息
 */
public class JvmDemo1_7 {
    public static void main(String[] args) throws InterruptedException{
        int i = 0;
        try {
            for (int j = 0; j < 100; j++) {
                String.valueOf(j).intern();
                i++;
            }
        }catch (Throwable e){
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}

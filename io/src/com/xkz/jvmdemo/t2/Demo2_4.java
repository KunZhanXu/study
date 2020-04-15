package com.xkz.jvmdemo.t2;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
/*
* 演示软引用，配合队列使用
*
* */
public class Demo2_4 {
    private static final int _4MB = 4 * 1024 *1024;

    public static void main(String[] args){
        List<SoftReference<byte[]>> list = new ArrayList<>();

        //引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        for (int i = 0; i < 5; i++) {
            //关联了引用队列,当软引用所关联的byte[]数组被回收时，软引用自己会加入到queue中去
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB],queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }

        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null){
            list.remove(poll);
            poll = queue.poll();
        }

        System.out.println("=======================");
        System.out.println("循环结束："+list.size());
        for (SoftReference<byte[]> ref: list) {
            System.out.println(ref.get());
        }
    }

}

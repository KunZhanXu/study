package com.xkz.demo01.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.lang.Throwable:类是Java语言中所有错误或异常的超类
 *      Exception:编译异常，进行编译（写代码）java程序出现问题
 *          RuntimeException：运行期异常，java程序运行过程中出现的问题
 *          异常相当于程序得了一个小毛病
 *      Error：错误
 */
public class Demo01Exception {
    public static void main(String[] args){
        //Exception：编译期异常，进行编译（写代码）java程序出现问题
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//用来格式化日期
//        Date date = null;
//        try {
//           date = sdf.parse("1999-09-09");//把字符串格式的日期，解析成Date格式日期
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(date);
        try{
            int[] arr = new int[1024*1024*1024];
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("后续代码");
    }
}


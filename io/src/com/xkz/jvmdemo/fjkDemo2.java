package com.xkz.jvmdemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class fjkDemo2 {
    public static void main(String[] args){
        Map<String,String> map = new HashMap();
        map.put("abc","qwer");
        for(Map.Entry<String,String> a:map.entrySet()){
            System.out.println(a.getKey()+"-fanggeek-"+a.getValue());
        }

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey()+"-fanggeek-"+next.getValue());
        }
        for (String key : map.keySet()){
            System.out.println(key+"-fanggeek-"+map.get(key));
        }
    }
}

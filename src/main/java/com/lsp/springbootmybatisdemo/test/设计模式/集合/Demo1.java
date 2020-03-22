package com.lsp.springbootmybatisdemo.test.设计模式.集合;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @FileName: Demo1
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/3/15 18:30
 */
public class Demo1 {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getValue());
        }

        System.out.println("------------------------------------");
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("------------------------------------");
        entries.forEach(key->{
            System.out.println(key);
        });

       Map map1 = new ConcurrentHashMap();
    }
}

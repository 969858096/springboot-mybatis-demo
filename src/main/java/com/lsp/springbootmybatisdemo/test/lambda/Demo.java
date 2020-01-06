package com.lsp.springbootmybatisdemo.test.lambda;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: Demo
 * @Description:  lambda表达式实现并行实现
 * @AuthOr: lsp
 * @Date: 2020/1/6 20:40
 */
public class Demo {


    public int add(List list){
        return list.parallelStream().mapToInt(a -> (int) a).sum();
    }

    public int test(List list){
        list.stream().forEach(System.out :: println);
        return 0;
    }

    public static void main(String[] args) {
       List<Integer> list = new ArrayList<>();
       list.add(1);
       list.add(1);
       list.add(1);
       list.add(1);
       list.add(1);

        int add = new Demo().add(list);
        System.out.println(add);

        int test = new Demo().test(list);
        System.out.println(test);
    }
}

package com.spring.blog2;

import java.util.*;

public class Study {
    public static void main(String[] args) {
/**
 *
 * TreeSet的有序和List中的元素有序有什么区别?
 * List 的有序是与元素放入的顺序一致。
 * TreeSet与放入元素的顺序无关，底层实现了一个自然排序
 */
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(9);
        list.add(4);
//        遍历集合元素  ,结果与放入顺序一致
        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println("------------------------------");
        Set<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(4);
        set.add(9);
        set.add(1);
        for (Integer i : set) {
            System.out.println(i);
        }
    }
}

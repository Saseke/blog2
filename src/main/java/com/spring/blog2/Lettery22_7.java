package com.spring.blog2;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Lettery22_7 {
    public static void main(String[] args) {
        //模拟22选7彩票开奖
        /**
         * 实质：产生7个[1,22]区间的随机数，开奖结果显示时需要从小到大排序，而且7个随机数不允许一样，使用Set
         */
        Random r = new Random();
        Set<Integer> nums = new TreeSet<>();
        while (nums.size() < 7) {
//            产生[1,22] 区间的随机数    [0,22)+1
//            产生区间[m,n]区间的随机数  r.nextInt(n-m+1)+m
//            r.nextInt(区间长度)+区间起点
            int a = r.nextInt(22) + 1;
            nums.add(a);
        }
        for (Integer i : nums) {
            System.out.println(i);
        }
    }
}

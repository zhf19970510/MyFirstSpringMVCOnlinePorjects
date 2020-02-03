package com.zhf.test;

import java.util.Random;

/**
 * @author ZengHongFa
 * @create 2020/2/2 0002 14:10
 */
public class Randomshuzi {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(10);
        System.out.println(a);
    }
}

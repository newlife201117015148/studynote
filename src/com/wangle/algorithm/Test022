package com.huawei.alm.swbomtree;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Test022 {
    public static void main(String[] args) {
        while(true) {
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            s.nextLine();
            if (n < 1) {
                System.out.println("只能输入正整数！！！");
                return;
            }


            long start = System.currentTimeMillis();
            System.out.println(findCount(n));
            System.out.println((System.currentTimeMillis() - start) + " ms");

            long start1 = System.currentTimeMillis();
            Map<Integer, BigInteger> map = new HashMap<>();
            System.out.println(findCountCache(n, map));
            System.out.println(System.currentTimeMillis() - start1 + " ms(cache)");

            long start2 = System.currentTimeMillis();
            System.out.println(new BigDecimal(findCountStack(n)));
            System.out.println(System.currentTimeMillis() - start2 + " ms (stack)");
        }
    }

    private static BigInteger findCount(int n) {
        if (n == 1) return BigInteger.ONE;
        if (n == 2) return BigInteger.TWO;
        return findCount(n-1).add(findCount(n-2));
    }

    private static BigInteger findCountCache(int n, Map<Integer, BigInteger> map) {
        if (n == 1) return BigInteger.ONE;
        if (n == 2) return BigInteger.TWO;
        if (map.get(n) != null) {
            return map.get(n);
        }
        BigInteger result= findCountCache(n-1, map).add(findCountCache(n-2, map));
        map.put(n, result);
        return result;
    }

    private static BigInteger findCountStack(int n) {
        if (n == 1) return BigInteger.ONE;
        if (n == 2) return BigInteger.TWO;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, BigInteger> map = new HashMap<>();
        map.put(1, BigInteger.ONE);
        map.put(2, BigInteger.TWO);
        stack.push(n);
        while(!stack.empty()) {
            Integer peek = stack.peek();
            if (map.get(peek) != null) {
                stack.pop();
                continue;
            }
            if (map.get(peek - 1) == null) {
                stack.push(peek - 1);
                continue;
            }
            if (map.get(peek - 2) == null) {
                stack.push(peek - 2);
                continue;
            }
            map.put(peek, map.get(peek - 1).add(map.get(peek - 2)));
            stack.pop();
        }
        return map.get(n);
    }
}

package com.algorithm.Week_03;

/**
 * @author HYY
 * @ClassName SolutionclimbStairs
 * @Description TODO
 * @Date 2020/7/10 21:34
 * @Version 1.0
 */
public class SolutionclimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    /**
     * 动态规划
     * s第一步
     * e第二步
     * s+e之和
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int s = 0;
        int e = 0;
        int m = 1;
        for (int i = 0; i < n; i++) {
            s = e;
            e = m;
            m = e + s;

        }
        return m;
    }


}
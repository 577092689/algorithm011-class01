package com.algorithm.Week_01;

/**
 * @author HYY
 * @ClassName Solution
 * @Description 旋转数组
 * @Date 2020/6/30 14:14
 * @Version 1.0
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 **/
public class SolutionRotate {
    /**
     * 方法 1：暴力
     *
     * @param nums
     * @param k
     */
    public void rotateOne(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            //第一次循环获取到最后一个数
            previous = nums[nums.length - 1];
            for (int i1 = 0; i1 < nums.length; i1++) {
                //获取数值记录temp
                temp = nums[i1];
                //将第一次记录数值给第一个索引
                nums[i1] = previous;
                //然后将第一个索引值给最后一个索引
                previous = temp;
            }
        }
    }


    /**
     * 方法 2：使用环状替换
     * 这个不太好理解需要仔细看几次
     *
     * @param nums
     * @param k
     */
    public void rotateThree(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int cur = i;
            int pre = nums[i];
            do {
                int next = (cur + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            } while (i != cur);
        }
    }

    /**
     * 方法 3：使用反转
     *
     * @param nums
     * @param k
     */
    public void rotateFour(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
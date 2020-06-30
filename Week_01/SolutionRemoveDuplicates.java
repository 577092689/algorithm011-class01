package com.algorithm.Week_01;

/**
 * @author HYY
 * @ClassName removeDuplicates
 * @Description 删除排序数组中的重复项
 * @Date 2020/6/30 14:03
 * @Version 1.0
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 **/
public class SolutionRemoveDuplicates {

    /**
     * 双指针法
     * 数组完成排序后，我们可以放置两个指针 ii 和 jj，其中 ii 是慢指针，而 jj 是快指针。只要 nums[i] = nums[j]nums[i]=nums[j]，我们就增加 jj 以跳过重复项。
     * <p>
     * 当我们遇到 nums[j] \neq nums[i]nums[j]
     * =nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]nums[j]）的值复制到 nums[i + 1]nums[i+1]。
     * 然后递增 ii，接着我们将再次重复相同的过程，直到 jj 到达数组的末尾为止。
     *
     * @param nums
     * @return
     */
    public int removeDuplicatesOne(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int i1 = 1; i1 < nums.length; i1++) {
            if (nums[i] != nums[i1]) {
                i++;
                if (i != i1) {
                    nums[i] = nums[i1];
                }
            }
        }
        return i + 1;
    }


    /**
     * 注解
     * 给出的数组必须是有序的不然这个无法完成解析
     * 因为需要判断索引值和后面索引值是否
     *
     * @param nums
     * @return
     */
    public static int removeDuplicatesTwo(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 1;
        for (int num : nums) {
            int num1 = nums[j - 1];
            if (num > num1) {
                nums[j++] = num;
            }
        }
        return j;
    }

}
package com.algorithm.Week_03;

import com.algorithm.entiy.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HYY
 * @ClassName SolutionInvertTree
 * @Description 翻转二叉树
 * @Date 2020/7/10 21:47
 * @Version 1.0
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 */
public class SolutionInvertTree {


    /***
     * 递归
     * @param root
     * @return
     */
    public TreeNode invertTreeV1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTreeV1(root.right);
        TreeNode left = invertTreeV1(root.left);
        root.left = right;
        root.right = left;
        return root;
    }


    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeV2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }


}
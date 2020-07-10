package com.algorithm.Week_03;

import com.algorithm.entiy.TreeNode;

import java.util.Stack;

/**
 * @author HYY
 * @ClassName SolutionIsValidBST
 * @Description 验证二叉搜索树
 * @Date 2020/7/10 21:51
 * @Version 1.0
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class SolutionIsValidBST {
    /**
     * 递归的解法
     *
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBSTV2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


}
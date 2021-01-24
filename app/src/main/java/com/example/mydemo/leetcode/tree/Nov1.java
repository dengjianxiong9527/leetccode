package com.example.mydemo.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianxiong.deng
 * @date 2020/11/2
 * @des
 */
public class Nov1 {
    public static void main(String[] args) {
        TreeNode testLeft1 = new TreeNode(4);
        TreeNode testLeft = new TreeNode(2);
        TreeNode testRight = new TreeNode(3);
        TreeNode test = new TreeNode(1);
        testLeft.left = testLeft1;
        test.left = testLeft;
        test.right = testRight;

        Solution solution = new Solution();

        System.out.println("val:" + solution.sumNumbers(test, 0));
    }

    public static class Solution {

        public int sumNumbers(TreeNode root, int index) {
            if (root == null) return 0;
            int val = index * 10 + root.val;
            if (root.left == null && root.right == null) return val;
            return sumNumbers(root.left, val) + sumNumbers(root.right, val);
        }

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 前序遍历 preorder = [3,9,20,15,7]
    //中序遍历 inorder = [9,3,15,20,7]
    // 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    Map<Integer, Integer> indexMap = new HashMap<>();
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);

    }

    TreeNode recur(int root, int left, int right) {
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        int i = indexMap.get(preorder[root]);
        node.left = recur(root + 1, left, i - 1);
        node.right = recur(root + i - left + 1, i + 1, right);
        return node;
    }

}

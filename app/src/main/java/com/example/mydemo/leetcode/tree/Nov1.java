package com.example.mydemo.demo.tree;

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

        System.out.println("val:" +  solution.sumNumbers(test, 0));
    }

    public static class Solution {

        public int sumNumbers(TreeNode root, int index) {
           if(root == null) return 0;
           int val = index * 10 + root.val;
           if(root.left == null && root.right == null) return val;
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

}

package com.example.mydemo.leetcode.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author jianxiong.deng
 * @date 2020/12/11
 * @des 输入:
 * 二叉查找树的深度(height)和大小(size)
 */
class Dec11_3 {

    public static void main(String arg[]) {
        TreeNode treeNode = new TreeNode(7);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(9);

        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(3);


        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode4.left = treeNode5;

//        System.out.println(maxDepth(treeNode));
//        System.out.println(SizeDepth(treeNode));
//
//        Dec11_3 dec11_3 = new Dec11_3();
//        dec11_3.firstUniqChar("abaccdeff");

        Dec11_3 dec11_3 = new Dec11_3();
        dec11_3.levelOrder1(treeNode);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /// 二叉树的高度
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            return (l > r) ? l + 1 : r + 1;
        }
    }

    /// 二叉树的节点数
    public static int SizeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return SizeDepth(root.left) + SizeDepth(root.right) + 1;
        }
    }

    ///  * levelOrder 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            ans.add(treeNode.val);
            if (treeNode.left != null) queue.add(treeNode.left);
            if (treeNode.right != null) queue.add(treeNode.right);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;

    }
    ///* firstUniqChar : 字符串中只出现一次的第一个char
    public char firstUniqChar(String s) {
        List<String> list = new ArrayList<>();
        Set<String> setChar = new HashSet<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(chars[i]);
            if (setChar.add(c)) {
                list.add(c);
            } else {
                if (list.contains(c)) {
                    list.remove(c);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
        return 'c';
    }

    /// 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
    /// 输入：root = [4,2,7,1,3,6,9]
    //输出：[4,7,2,9,6,3,1]
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }

    public TreeNode stackMirrorTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode.left != null) stack.add(treeNode.left);
            if (treeNode.right != null) stack.add(treeNode.right);
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
        return root;
    }

    ///请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

    public boolean isSymmetric(TreeNode root) {
        return false;
    }

    /// 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    public int sumNums(int n) {
        return n == 0 ? 0 : n + sumNums(n - 1);
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        List<List<Integer>> listsAll = new ArrayList<>();
        treeNodeQueue.add(root);

        while (!treeNodeQueue.isEmpty()) {
            List<Integer>  list = new ArrayList<>();
            int x = treeNodeQueue.size();
            for(int i = 0; i < x; i++){
                TreeNode treeNode = treeNodeQueue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) treeNodeQueue.add(treeNode.left);
                if (treeNode.right != null) treeNodeQueue.add(treeNode.right);

            }
            listsAll.add(list);

        }
        return listsAll;
    }

}

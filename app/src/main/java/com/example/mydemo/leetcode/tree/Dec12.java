package com.example.mydemo.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author jianxiong.deng
 * @date 2020/12/11
 * @des 输入:给定如下二叉树，以及目标和 sum = 22，
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 */
class Dec12 {

    public static void main(String arg[]) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(8);

        TreeNode treeNode3 = new TreeNode(11);
        TreeNode treeNode4 = new TreeNode(13);
        TreeNode treeNode5 = new TreeNode(4);

        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(1);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode5.right = treeNode8;

        //System.out.println(hasPathSum(treeNode, 22));
        firstRoot(treeNode);
        System.out.println();

        MidTree midTree = new MidTree();
        midTree.midRoot(treeNode);
        System.out.println();
        midTree.gennalMidRoot(treeNode);

        System.out.println();
        LastTree lastTree = new LastTree();
        lastTree.lastRoot(treeNode);
        System.out.println();
        lastTree.gennalLastRoot(treeNode);
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

    public static boolean hasPathSum(TreeNode root, int sum) {
        int val = root.val;
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /// 先根遍历: 5->4->11->7->2->8->13-4->1
    /// 递归
    public static void firstRoot(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "-");
            firstRoot(root.left);
            firstRoot(root.right);
        }
    }

    /// 非递归
    public static List<Integer> genalFirstRoot(TreeNode root) {
        List<Integer> listTree = new ArrayList<>();
        if (root == null) {
            return listTree;
        }
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.add(root);
        while (!treeNodeStack.isEmpty()) {
            TreeNode treeNode = treeNodeStack.pop();
            listTree.add(treeNode.val);
            treeNodeStack.add(treeNode.right);
            treeNodeStack.add(treeNode.left);
        }
        return listTree;
    }

    /// 中根遍历:
    public static class MidTree {
        /// 递归
        public void midRoot(TreeNode root) {
            if (root != null) {
                midRoot(root.left);
                System.out.print(root.val + "-");
                midRoot(root.right);
            }
        }

        /// 非递归
        public List<Integer> gennalMidRoot(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode cur = root;
            while (cur != null || !stack.empty()) {
                while (cur != null) {
                    stack.add(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;

            }

            for (int i = 0; i < list.size(); i++) {

                System.out.print(list.get(i) + "-");
            }

            return list;
        }
    }

    /// 后根遍历
    public static class LastTree {
        /// 递归
        public void lastRoot(TreeNode root) {
            if (root != null) {
                lastRoot(root.left);
                lastRoot(root.right);
                System.out.print(root.val + "-");
            }
        }

        /// 非递归
        public List<Integer> gennalLastRoot(TreeNode root) {
            List<Integer> resultList = new ArrayList<>();
            if (root == null) {
                return resultList;
            }
            Map<TreeNode, Integer> visitedMap = new HashMap<>();
            Stack<TreeNode> toBeVisitedStack = new Stack<>();
            toBeVisitedStack.push(root);
            while (! toBeVisitedStack.isEmpty()){
                TreeNode treeNode = toBeVisitedStack.peek();
                if(treeNode.left == null && treeNode.right == null){
                    resultList.add(treeNode.val);
                    visitedMap.put(treeNode, 1);
                    toBeVisitedStack.pop();
                    continue;
                }else if(!((treeNode.left != null && visitedMap.get(treeNode.left) == null) || (treeNode.right != null && visitedMap.get(treeNode.right) == null))){
                        resultList.add(treeNode.val);
                        toBeVisitedStack.pop();
                        visitedMap.put(treeNode, 1);
                        continue;
                }

                if(treeNode.left != null){
                    while (treeNode.left != null && visitedMap.get(treeNode.left) == null){
                        toBeVisitedStack.push(treeNode.left);
                        treeNode = treeNode.left;
                    }
                }

                if(treeNode.right != null){
                  if(visitedMap.get(treeNode.right) == null){
                       toBeVisitedStack.push(treeNode.right);
                  }
                }

            }
            return resultList;
        }

    }


}

package com.example.mydemo.leetcode.link;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianxiong.deng
 * @date 2020/12/7
 */
class Dec6 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        Dec6 solution = new Dec6();
       // solution.swapPairs(listNode);

        solution.reversePrint(listNode);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //  * @des 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    // * 输入：head = [1,2,3,4]
    // * 输出：[2,1,4,3]
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
//        System.out.println("a:" + next.val);
        head.next = swapPairs(next.next);
//        System.out.println("a1:" + head.val);
        next.next = head;

        return next;
    }

    //输入：head = [1,3,2]
    //输出：[2,3,1]
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int[] a = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            a[i] = list.get(list.size() - i - 1);
            System.out.println("a: " + i + "---" + a[i]);
        }

        return a;
    }


}

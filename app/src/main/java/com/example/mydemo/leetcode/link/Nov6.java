package com.example.mydemo.demo.link;

import java.util.Stack;

/**
 * @author jianxiong.deng
 * @date 2020/11/14
 * @des 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * 注意点是倒数k 就是第一个
 */
class Nov6 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
       ListNode listNode4 = new ListNode(4);

        listNode.next = listNode2;
        //listNode2.next = listNode3;
        //listNode3.next = listNode4;

        getKthFromEnd(listNode, 2);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode temp = head;
        ListNode listNode = new ListNode(0);
        int i = 1;
        while (head.next != null) {
            i++;
            head = head.next;
        }

        if (i == 1 || i == k) {
            return temp;
        }

        for(int j = 1; j <= i; j++){
            temp = temp.next;
            if(j ==  (i - k )){
                listNode = temp;
                break;
            }

        }

        System.out.println("listNode.val: " + listNode.val);

        return listNode;
    }

}

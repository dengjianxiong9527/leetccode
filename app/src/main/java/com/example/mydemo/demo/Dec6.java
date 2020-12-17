package com.example.mydemo.demo;

/**
 * @author jianxiong.deng
 * @date 2020/12/7
 * @des 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
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
        solution.swapPairs(listNode);

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

    public static ListNode swapPairs(ListNode head) {
        if(head == null && head.next == null)
            return head;


        ListNode next = head.next;
        swapPairs(next.next);
        next.next = head;

        return next;
    }

//    public int[] reversePrint(ListNode head) {
//        int a = 0;
//        while (head != null){
//            a++;
//        }
//    }
}

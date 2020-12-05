package com.example.mydemo.demo;

/**
 * @author jianxiong.deng
 * @date 2020/12/3
 * @des 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
class dec3 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        Solution solution = new Solution();
        solution.reverseList(listNode);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {

            ListNode prev = null;
            ListNode next = null;

            while (head.next != null) {
                next = head.next;
                head.next = prev;

                prev = head;

                head = next;
            }
            head.next = prev;

            while (head != null) {
                System.out.print(head.val);
                head = head.next;
            }
            return head;
        }
    }
}

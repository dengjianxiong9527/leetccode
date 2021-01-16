package com.example.mydemo.demo.link;

/**
 * @author jianxiong.deng
 * @date 2020/12/8
 * @des 4>-4>-3>-2>-1>-1:出输 4>-3>-1 ,4>-2>-1:入输 :例示
 */
public class Dec8 {
    public static void main(String[] args) {
        ListNode listNodea = new ListNode(1);
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode.next = listNode2;
        listNode2.next = listNode4;

        listNodea.next = listNode3;
        listNode3.next = listNode4;

        Dec8 solution = new Dec8();

        solution.Solution(listNode, listNodea);
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

    private  ListNode Solution(ListNode listNode1, ListNode listNode2) {
        ListNode listNode = new ListNode(-1);

        ListNode prev = listNode;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                prev.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                prev.next = listNode2;
                listNode2 = listNode2.next;
            }
            prev = prev.next;
        }
        prev.next = listNode1 == null ? listNode2 : listNode1;

        return listNode.next;
    }

}

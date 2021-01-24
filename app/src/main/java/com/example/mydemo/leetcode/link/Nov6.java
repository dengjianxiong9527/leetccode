package com.example.mydemo.leetcode.link;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jianxiong.deng
 * @date 2020/11/14
 */
class Nov6 {
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

        getKthFromEnd(listNode, 1);

        Nov6 nov6 = new Nov6();
        nov6.removeDuplicateNodes(listNode);

        nov6.kthToLast(listNode, 1);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // * @des 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
    // * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
    // * 注意点是倒数k 就是第一个

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

        for (int j = 1; j <= i; j++) {
            temp = temp.next;
            if (j == (i - k)) {
                listNode = temp;
                break;
            }

        }

        System.out.println("listNode.val: " + listNode.val);

        return listNode;
    }

    // 输入： 1->2->3->4->5 和 k = 2
    //输出： 4
    public int kthToLast(ListNode head, int k) {
        int i = 1;
        int j = 1;
        int val = 0;
        ListNode temp = head;
        while (head.next != null) {
            i++;
            head = head.next;
        }
        if (i == 1 || i == k) {
            val = head.val;
        }
        while (temp != null) {

            if (k == (i + 1 - j)) {
                val = temp.val;
            }
            j++;
            temp = temp.next;

        }
        System.out.println("val:" + val);
        return val;
    }


    //输入两个链表，找出它们的第一个公共节点。
    //intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
    //输出：Reference of the node with value = 8
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = lenght(headA);
        int lenB = lenght(headB);

        while (lenA != lenB) {
            if (lenA > lenB) {
                headA = headA.next;
                lenA--;
            } else {
                headB = headB.next;
                lenB--;
            }

        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int lenght(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    //实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
    // 输入：单向链表a->b->c->d->e->f中的节点c
    //结果：不返回任何数据，但该链表变为a->b->d->e->f

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //编写代码，移除未排序链表中的重复节点。保留最开始出现的节点
    //  输入：[1, 2, 3, 3, 2, 1]
    // 输出：[1, 2, 3]

    public ListNode removeDuplicateNodes(ListNode head) {

        Set<Integer> listNodes = new HashSet<>();
        ListNode node = head;
        listNodes.add(node.val);
        while (node.next != null) {
            ListNode cur = node.next;
            if (listNodes.add(cur.val)) {
                node = node.next;
            } else {
                node.next = node.next.next;
            }
        }
        node.next = null;

        return head;
    }

}

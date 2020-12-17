package com.example.mydemo.demo;

import java.util.Stack;

/**
 * @author jianxiong.deng
 * @date 2020/12/3
 * @des 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
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
      //  solution.reverseList(listNode);
       // solution.reverse(listNode);
        //solution.reverseBetween(listNode, 2, 4);
        solution.deleteValNode(listNode, 3);
      //  solution.deleteValNode(listNode, 1);
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

        public  ListNode reverse(ListNode head){
            ListNode cur = null;
            ListNode pre = head;

            while (pre != null){
                ListNode listNode = pre.next;
                pre.next = cur;
                cur = pre;

                pre = listNode;
            }

            while (cur != null) {
                System.out.print(cur.val);
                cur = cur.next;
            }
            return  cur;
        }

        /// 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
        public ListNode reverseBetween(ListNode head, int m, int n) {
            int c = 0;
            ListNode head1 = null;
            ListNode cur = null;
            ListNode pre = head;


            while (pre != null){
                c++;
                ListNode listNode = pre.next;
                if( c >= m && c <= n){
                    pre.next = cur;
                    cur = pre;
                }else {
                    head1 = pre;
                }
                pre = listNode;
            }

            while (cur != null) {
                System.out.print(cur.val);
                cur = cur.next;
            }
            return  cur;
        }

        /// 根据索引删除指定节点
        public  void deleteNode(ListNode node, int val) {
            int a = 0;
            ListNode head = node;
            while (head != null){
                a++;
                if(a + 1 == val){
                    if( head.next != null &&  head.next.next != null){
                        head.next = head.next.next;
                        break;
                    }else {
                        head.next = null;
                    }
                }
                head = head.next;
            }

            while (node != null) {
                System.out.print(node.val);
                node = node.next;
            }
        }
        /// 删除指定节点
        public  ListNode deleteValNode(ListNode node, int val) {
            //虚拟头节点的值用不到，随意赋值
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = node;

            ListNode prev = dummyHead;

            while (prev.next != null){

            }

            while (dummyHead != null) {
                System.out.print(dummyHead.val);
                dummyHead = dummyHead.next;
            }

            return dummyHead.next;
        }
    }

}

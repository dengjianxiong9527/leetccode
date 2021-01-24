package com.example.mydemo.leetcode.link;

/**
 * @author jianxiong.deng
 * @date 2020/12/3
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

        //  * @des 输入: 1->2->3->4->5->NULL
        // * 输出: 5->4->3->2->1->NULL
        public ListNode reverseList(ListNode head) {
            ListNode cur = null;
            ListNode pre = head;
            while (pre != null) {
                ListNode next = pre.next;
                pre.next = cur;
                cur = pre;
                pre = next;
            }
            return cur;
        }


        /// 递归 的方法反转
        // * @des 输入: 1->2->3->4->5->NULL
        // * 输出: 5->4->3->2->1->NULL
        public ListNode reverseA(ListNode head, ListNode pre) {
            ListNode next = head.next;
            head.next = pre;
            return reverseA(next, head);
        }

        //  * @des 输入: 1->2->3->4->5->NULL
        // * 输出: 5->4->3->2->1->NULL
        public ListNode reverse(ListNode head) {
            ListNode cur = null;
            ListNode pre = head;

            while (pre != null) {
                ListNode listNode = pre.next;
                pre.next = cur;
                cur = pre;

                pre = listNode;
            }

            while (cur != null) {
                System.out.print(cur.val);
                cur = cur.next;
            }
            return cur;
        }

        /// 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
        public ListNode reverseBetween(ListNode head, int m, int n) {
            int c = 0;
            ListNode head1 = null;
            ListNode cur = null;
            ListNode pre = head;


            while (pre != null) {
                c++;
                ListNode listNode = pre.next;
                if (c >= m && c <= n) {
                    pre.next = cur;
                    cur = pre;
                } else {
                    head1 = pre;
                }
                pre = listNode;
            }

            while (cur != null) {
                System.out.print(cur.val);
                cur = cur.next;
            }
            return cur;
        }

        /// 根据索引删除指定节点
        public void deleteNode(ListNode node, int val) {
            int a = 0;
            ListNode head = node;
            while (head != null) {
                a++;
                if (a + 1 == val) {
                    if (head.next != null && head.next.next != null) {
                        head.next = head.next.next;
                        break;
                    } else {
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
        public ListNode deleteValNode(ListNode node, int val) {
            if(node.val == val) return node.next;
            ListNode listNode = node;
            while (listNode.next.val != val){
                listNode = listNode.next;
            }
            if(listNode.next != null){
                listNode.next = listNode.next.next;
            }
            return node;
        }
    }

}

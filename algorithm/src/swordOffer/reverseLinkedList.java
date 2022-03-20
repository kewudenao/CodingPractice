package swordOffer;

import java.util.ArrayList;

/**
 *  定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *   解题思路：题目核心是利用头插法，每次都将元素插入到链表的首位。
 *   示例:
 *   输入: 1->2->3->4->5->NULL
 *   输出: 5->4->3->2->1->NULL
 *  https://leetcode-cn.com/problems/reverse-linked-list/
 */

public class reverseLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode() {

        }
    }



    public ListNode reverseList(ListNode head) {
        ListNode a = null;
        ListNode b = null;
        ArrayList<Integer> c = new ArrayList<>() ;
        Integer[] d;
        d = c.toArray(new Integer[0]);

        while (head!=null){
            a = head;
            head = head.next;
            a.next = b;
            b = a;
        }

        return b;


    }
}

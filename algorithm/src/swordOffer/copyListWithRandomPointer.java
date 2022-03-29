package swordOffer;
//https://leetcode-cn.com/problems/copy-list-with-random-pointer/


import java.util.HashMap;
//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。



public class copyListWithRandomPointer {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    /*
        * 用原链表的内存地址做key ， 新链表的内存地址做value 放入hashMap中
        * 设置新链表的random
        * 取出map中链表头的地址 返回
     */
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node cux = head;
        HashMap<Node,Node> map = new HashMap();
        while(cux!=null){
            map.put(cux,new Node(cux.val));
            cux = cux.next;
        }
        cux = head;
        while(cux!=null){
            map.get(cux).next = map.get(cux.next);
            map.get(cux).random = map.get(cux.random);
            cux = cux.next;
        }
        return map.get(head);
    }

    /**
     *  1.1 新链表a.next = 原链表b.next 1.2 将原链表的next 指向新链表  此时新链表和旧链表合成了一个链表n
     *  2.1  拼装好后新链表a.random = 原链表 b.random.next
     *  3.1 将新链表 与 原链表拆分
     *  4.1 将原链表的next置空
     *  5.1 返回旧链表
     */
    class Solution {
        public Node copyRandomList(Node head) {
            Node cux = head;
            while (cux != null) {
                Node node = new Node(cux.val);
                node.next = cux.next;
                cux.next = node;
                cux = cux.next.next;
            }
            cux = head;
            while (cux != null) {
                if (cux.random != null)
                    cux.next.random = cux.random.next;
                cux = cux.next.next;

            }
            cux = head.next;
            Node returnNode = head.next;
            Node pre = head;
            while (cux.next != null) {
                pre.next = pre.next.next;
                cux.next = cux.next.next;
                pre = pre.next;
                cux = cux.next;

            }
            pre.next = null;
            return returnNode;

        }
    }
}

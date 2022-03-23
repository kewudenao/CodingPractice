package swordOffer;

import java.util.ArrayList;

public class getKthFromEnd {
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode methodOne(ListNode head, int k) {
        ArrayList<ListNode> list = new ArrayList();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp);
            temp= temp.next;
        }
        return list.get(list.size()-k);
    }

    /**
     *  快慢指针 找到倒数第k个元素，也就是快指针和慢指针的距离为k
     * @param head
     * @param k
     * @return
     */
    public ListNode methodTwo(ListNode head, int k) {
        ListNode before = head;
        ListNode after = head;
        for(int i =0;i<k;i++){
            before = before.next;
        }
        while(before!=null){
            before = before.next;
            after = after.next;
        }
        return after;
    }

}

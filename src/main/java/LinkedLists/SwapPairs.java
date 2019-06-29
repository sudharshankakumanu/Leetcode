package LinkedLists;

import Util.ListNode;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode l1 = head;
        ListNode l2 = head.next;

        ListNode nextNode = l2.next;

        l2.next = l1;

        l1.next = swapPairs(nextNode);

        return l2;
    }

    public ListNode swapPairs_iterative(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        while(cur.next != null && cur.next.next != null){

            ListNode l1 = cur.next;
            ListNode l2 = cur.next.next;

            cur.next = l2;
            l1.next = l2.next;
            l2.next = l1;
            cur = l1;
        }

        return  dummy.next;

    }


}

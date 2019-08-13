package LinkedLists;

import Util.ListNode;

import java.util.List;

public class ReOrderList {

    public void reorderList(ListNode head) {

        /*
        Idea is to reverse the second half of the list and merge them
        1->2->3->4->5->6
        1-2-3-6-5-4
        l1    l2
        merge(l1,l2)
         */

        if (head == null || head.next == null)
            return;

        ListNode fastPtr = head, slowPtr = head;
        ListNode pre = null;
        while (fastPtr.next != null){
            pre = slowPtr; // used to break first and second halves
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        pre.next = null; // point end of first half to null
        ListNode l1 = head;

        ListNode l2 = ReverseLinkedList.reverse(slowPtr);

        //merge two halves
       merge(l1,l2);

    }

    private void merge(ListNode l1, ListNode l2) {

        ListNode t1 = null;
        ListNode t2 = null;

        while(l1 != null && l2 != null){

            t1 = l1.next;
            l1.next = l2;
            if(t1 == null) break; // we can break if t1 is null, we don't need to point l2 to null because if there is an element existing
            // after l2, it should point to that, otherwise it anyways points to null;
            t2 = l2.next;
            l2.next = t1;

            l1 = t1;
            l2 = t2;

        }
    }
}

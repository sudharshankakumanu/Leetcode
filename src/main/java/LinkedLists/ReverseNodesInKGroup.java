package LinkedLists;

import Util.ListNode;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode l2 = l1.next.next.next.next.next = new ListNode(6);

        ListNode node = reverseRegular(l1,l2);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }


    }

    public void reverseKGroup(ListNode head, int k) {

//        if(head == null || head.next == null || k ==1) return head;
//
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode begin = dummy;
//
//        int count = 0;
//        while(head != null){
//            count++;
//
//
//            if(count % k == 0) {
//
//
//            }
//            if(cur == null) return temp.next;
//            cur = cur.next;
//        }
    }

    public static ListNode reverseRegular(ListNode begin, ListNode end){

        if(begin == end) return begin;

        ListNode dummy = new ListNode(-1);
        dummy.next = begin;
        ListNode pre = dummy;
        ListNode cur = dummy.next;

        while(cur != end){

            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }
        cur.next = pre;
        dummy = null;
        return cur;
    }
}

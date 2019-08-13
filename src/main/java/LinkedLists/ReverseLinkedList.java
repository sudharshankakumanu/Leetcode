package LinkedLists;

import Util.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode node = reverse(l1);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode reverse(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode pre = null;


        while(head != null){

            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}

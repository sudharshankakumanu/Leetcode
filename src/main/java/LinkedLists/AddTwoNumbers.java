package LinkedLists;

import Util.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args){

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);

        ListNode l = addTwoNumbers(l1,l2);

        while(l != null){
            System.out.println(l.val);
            l = l.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode temp = head;


        int carry = 0;
        while(l1 != null || l2 != null) {

            int sum = 0;

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            int val = (sum + carry)  % 10;
            carry = (sum + carry) / 10;

            ListNode l = new ListNode(val);
            temp.next = l;
            temp = l;
        }

        if(carry != 0)
            temp.next = new ListNode(carry);

        return head.next;


    }

}

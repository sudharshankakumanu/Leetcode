package LinkedLists;

import Util.ListNode;

import java.util.List;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode l2 = l1.next.next.next.next.next = new ListNode(6);

        ListNode node = reverseKGroupRecursive(l1,3);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }


    }

    public static ListNode reverseKGroupRecursive(ListNode head, int k) {
        if(head == null || head.next == null || k < 2) return head;

        ListNode curr = head;
        int count = 0;

        while(curr != null && count < k){ //curr reaches k+1th node
            curr = curr.next;
            count++;
        }
        // if we had reached null beforereaching count = k then we can just return head;
        if(count == k) {

            curr = reverseKGroupRecursive(curr , k);

            // now reverse the first K elements
            while(count-- > 0){

                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }

            return curr;
        }

        return head;

    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//
//       if(head == null || head.next == null || k ==1) return head;
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
//                ListNode next = head.next;
//                begin = reverseRegular(begin, head);
//                head = next;
//
//            }
//            else {
//                head = head.next;
//            }
//        }
//    }
//
//    public static ListNode reverseRegular(ListNode begin, ListNode end){
//
//        if(begin == end) return begin;
//
//        ListNode pre = null;
//        ListNode next = null;
//
//        while(begin != null && begin != end.next){
//
//            next = begin.next;
//            begin.next = pre;
//            pre = begin;
//            begin = next;
//        }
//
//        return end;
//    }
}

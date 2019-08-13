package LinkedLists;

import Util.ListNode;

import java.util.List;
import java.util.Stack;

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

       //using stacks
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }


        ListNode temp = null;
        ListNode head = null;
        int sum = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){



            if(!s1.isEmpty()) sum += s1.pop();
            if(!s2.isEmpty()) sum += s2.pop();

           // sum +=  carry;

            head = new ListNode(sum % 10);
            head.next = temp;
            temp = head;

            sum = sum / 10;

        }

        if(sum != 0){
            ListNode node = new ListNode(sum);
            node.next = head;
            return node;
        }

        return head;

    }
}

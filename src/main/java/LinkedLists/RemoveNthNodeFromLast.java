package LinkedLists;

import Util.ListNode;

import java.util.List;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromLast {
    public static void main(String[] args) {

        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = null;

        ListNode res = removeNthFromEnd(l , 1);

        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode fastNode = temp;
        ListNode slowNode = temp;

        int count = 0;

        while(fastNode != null){ // this move the slowPointer to the previous node of the node to be removed

            if (count > n){
                slowNode = slowNode.next;
            }

            fastNode = fastNode.next;
            count++;
        }

        ListNode nodeToRemove = slowNode.next;

        slowNode.next = nodeToRemove.next;
        nodeToRemove.next = null;

        return temp.next;

    }
}

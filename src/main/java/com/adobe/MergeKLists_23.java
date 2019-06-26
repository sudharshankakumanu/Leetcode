package com.adobe;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists_23 {

    public static void main(String[] args) {


    }
    public ListNode mergeKLists(List<ListNode> lists) {

        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), (ListNode a,ListNode b)->a.val-b.val);

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        for(ListNode node : lists){

            if(node != null)
                pq.add(node);
        }

        while(!pq.isEmpty()){

            temp.next = pq.poll();
            temp = temp.next;

            if(temp.next != null){
                pq.offer(temp.next);
            }
        }

        return dummy.next;

    }

     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

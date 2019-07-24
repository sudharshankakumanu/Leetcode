package Design;

import java.util.HashMap;

public class LRUcache_146 {

    HashMap<Integer, Node> map;
    int capacity, count;
    Node head, tail;

    public LRUcache_146(int capacity) {

        this.capacity = capacity;
        count = 0;
        map = new HashMap<>();

        head.val = 0;
        tail.val = 0;

        head.pre = null;
        head.next = tail;

        tail.pre = head;
        tail.next = null;
    }

    public int get(int key) {

        if(map.containsKey(key)){

            Node n = map.get(key);
            deleteNode(n);
            return n.val;
        }

        else{
            return -1;
        }

    }

    public void put(int key, int value) {

        if(map.containsKey(key)){
            Node n = map.get(key);
            n.val = value;

            deleteNode(n);
            addToHead(n);
        }

        else {
            Node n = new Node();
            n.val = value;
            map.put(key, n);
            if (count < capacity) {
                count++;
                addToHead(n);
            } else {
                map.remove(tail.pre.val);
                deleteNode(tail.pre);
                addToHead(n);
            }


        }

    }

    public void deleteNode(Node node){

        node.pre.next = node.next;
        node.next.pre = node.pre;

        addToHead(node);
    }

    public void addToHead(Node node){

        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
    }



    public class Node {

        int val;
        Node pre;
        Node next;

    }

}

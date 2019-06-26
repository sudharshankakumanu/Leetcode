package Arrays;

import java.util.*;

public class TopKfrequentWords {

    public static void main (String[] args){

        String[] str = {"i", "love", "leetcode", "i", "love", "coding"};

        List<String> l = topKFrequent(str, 2);
        System.out.println(l);
        test(str);

        String s1 = "a";
        String s2 = "b";
        System.out.println(s2.compareTo(s1));

    }

    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        List<String> result = new LinkedList<>();

        for(String s : words){
            map.put(s , map.getOrDefault(s, 0) + 1);
        }

        // note here we are maintaining min heap, poll will return less freq element
        Comparator<Map.Entry<String, Integer>> comp = (a,b) -> a.getValue() == b.getValue() ?
                a.getKey().compareTo(b.getKey()) : Integer.compare(a.getValue(), b.getValue());

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue(comp);

        for(Map.Entry<String, Integer> entry : map.entrySet()){

            pq.add(entry);

//            if(pq.size() > k) {
//                pq.poll(); // removes the less freq element
//            }

        }

        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;




    }

    public static void test(String[] words) {

        Map<String, Integer> map = new HashMap<>();
        List<String> result = new LinkedList<>();

        for(String s : words){
            map.put(s , map.getOrDefault(s, 0) + 1);
        }

        // note here we are maintaining min heap, poll will return less freq element
        Comparator<Map.Entry<String, Integer>> comp = (a,b) -> a.getKey() == b.getKey() ?
                a.getKey().compareTo(b.getKey()) : Integer.compare(a.getValue(), b.getValue());

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue(comp);

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.add(entry);
        }

        while(!pq.isEmpty()){

            Map.Entry<String, Integer> e = pq.poll();
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

    }
}

package TreesGraphs.Graph;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {

        String[] arr = {
        "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };

        System.out.println(alienOrder(arr));
    }

    public static String alienOrder(String[] words) {

        String result = "";

        // this map contains c as key ans set of characters that occur after c as value.
        Map<Character, Set<Character>> graph = new HashMap<>();
        //
        Map<Character, Integer> degree = new HashMap<>();

        for(String w : words){

            for(Character c: w.toCharArray()){

                degree.put(c, 0);
            }
        }

        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<>();
                    if(graph.containsKey(c1)) set=graph.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        graph.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(Character c : degree.keySet()){

            if(degree.get(c) == 0){
                queue.add(c);
            }
        }

        while(!queue.isEmpty()){

            char c = queue.poll();

            result+=c;

            if(graph.containsKey(c)){

                for(Character ch : graph.get(c)){
                    degree.put(ch, degree.get(ch) - 1);
                    if(degree.get(ch) == 0){
                        queue.add(ch);
                    }
                }
            }


        }

        return result;

    }
}

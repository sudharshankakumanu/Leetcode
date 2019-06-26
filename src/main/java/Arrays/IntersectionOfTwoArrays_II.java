package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays_II {

    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i : nums1){
            map.put(i , map.getOrDefault(i , 0) + 1);
        }

        for(int j : nums2){

            if( map.get(j) != null && map.get(j) > 0){
                res.add(j);
                int count = map.get(j);
                map.put(j , count -1);
            }
        }

        int[] arr = new int[res.size()];

        int j = 0;
        for (int i : res){
           arr[j++] = i;
        }

        return arr;

    }
}

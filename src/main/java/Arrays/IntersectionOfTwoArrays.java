package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersectSet = new HashSet<>(); // this to avoid duplicates
        List<Integer> list = new ArrayList<>();

        for(int i : nums1){
            set.add(i);
        }

        for(int j : nums2){
            if(set.contains(j)){
                intersectSet.add(j);
            }
        }

        int[] res = new int[intersectSet.size()];

        int i = 0;
        for (Integer num : intersectSet) {
            res[i++] = num;
        }
        return res;

    }

}

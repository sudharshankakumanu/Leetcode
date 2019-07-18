package BackTracking;

//https://leetcode.com/problems/combinations/

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {

        System.out.println(combine(4,2));

    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        if(n == 0) return res;

        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
           nums[i] = i+1;
        }

        helper(res, nums, k, new ArrayList<>(), 0);

        return res;
    }

    private static void helper(List<List<Integer>> res, int[] nums, int k, List<Integer> subList, int start) {

        if(subList.size() == k){
            res.add(new ArrayList<>(subList));
        }

        for(int i = start; i < nums.length; i++){

            subList.add(nums[i]);
            helper(res, nums, k, subList, i+1);
            subList.remove(subList.size()-1);
        }

    }


}

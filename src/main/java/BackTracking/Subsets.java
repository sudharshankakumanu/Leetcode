package BackTracking;

//https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        int[] arr = {1,2,3};
        System.out.println(subsets(arr));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return  res;

        helper(res,nums, new ArrayList<>(), 0);

        return res;
    }

    private static void helper(List<List<Integer>> res, int[] nums, ArrayList<Integer> subList, int start) {

        if(subList.size() <= nums.length){
            res.add(new ArrayList<>(subList));
        }

        for(int i = start; i < nums.length; i++){
            subList.add(nums[i]);
            helper(res, nums, subList, i + 1);
            subList.remove(subList.size() - 1);
        }
    }
}

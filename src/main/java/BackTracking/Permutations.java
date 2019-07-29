package BackTracking;

//https://leetcode.com/problems/permutations/

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {

        int[] arr = {1,2,3};
        System.out.println(permute(arr));
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return  res;

        helper(res, nums, new ArrayList<>());

        return res;


    }

    private static void helper(List<List<Integer>> res, int[] nums, ArrayList<Integer> subList) {

        if(subList.size() == nums.length){
            res.add(new ArrayList<>(subList));
        }

        else{

            for(int i = 0; i < nums.length; i++){

                if(subList.contains(nums[i])) continue; // if element already added to subList, skip it
                subList.add(nums[i]);
                helper(res, nums, subList);
                subList.remove(subList.size() - 1);

            }
        }


    }


}

package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII {

    public static void main(String[] args) {

        int[] arr = {2,5,2,1,2};
        System.out.println(combinationSum2(arr, 5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        helper(res, candidates, target, 0, new ArrayList<>());

        return res;

    }

    private static void helper(List<List<Integer>> res, int[] candidates, int remain, int start, List<Integer> subList) {

        if(remain == 0){
           res.add(new ArrayList<>(subList)) ;
           return;
        }
        if(remain < 0) return;

        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1]) continue; /** skip duplicates */
            subList.add(candidates[i]);
            helper(res, candidates, remain - candidates[i], i + 1, subList );
            subList.remove(subList.size() - 1);
        }

    }


}

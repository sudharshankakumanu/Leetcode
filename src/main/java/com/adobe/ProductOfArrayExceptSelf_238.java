package com.adobe;

public class ProductOfArrayExceptSelf_238 {

    public static void main(String[] args) {

    }

    public static int[] productExceptSelf(int[] nums) {

        //left[i] is prod of all elements before i
        int [] left = new int[nums.length];
        //right[i] is prod of all elements after i
        int [] right = new int[nums.length];
        int[] prod = new int[nums.length];

        left[0] = 1;
        for(int i = 1; i < nums.length; i++){
            left[i] = left[i-1]*nums[i-1];
        }

        right[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0; i--){
            right[i] = right[i+1]*nums[i+1];
        }

        for(int i = 0; i < nums.length; i++){
            prod[i] = left[i]*right[i];
        }

        return prod;


    }

}

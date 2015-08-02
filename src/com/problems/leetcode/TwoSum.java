package com.problems.leetcode;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        
        for(int i = 0 ; i<nums.length;i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i])+1, i+1};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
        
    }


    public static void main(String[] args){
        int[] arr = {2, 7, 11, 15};
        int[] sol = twoSum(arr, 9);
        System.out.println(sol[0] + " , " + sol[1]);
    }

}
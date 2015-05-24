package com.problems.leetcode;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        
        for(int i = 0 ; i<nums.length;i++){
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i])+1, i+1};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
        
    }
}
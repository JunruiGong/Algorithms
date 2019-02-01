package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode-217-Contains Duplicate
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * Example
 * Input: [1,2,3,1]
 * Output: true
 */

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer>map = new HashMap<Integer, Integer>();


        for(int i :nums){
            if(map.containsKey(i)){
                return true;
            }else{
                map.put(i,1);
            }
        }

        return false;
    }
}

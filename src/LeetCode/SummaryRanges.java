package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-228-Summary Ranges
 *
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example 1:
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 *
 *
 * Example 2:
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums==null||nums.length<1){
            return list;
        }


        int start = nums[0];
        int end = nums[0];

        for (int i =0;i<nums.length;i++){
            if (i+1>=nums.length){
                if (start==end){
                    list.add(String.valueOf(start));
                }else{
                    String temp = start+"->"+end;
                    list.add(temp);
                }
                break;
            }
            if (nums[i+1]==nums[i]+1 ){
                end = nums[i+1];
            }else{
                if (start==end){
                    list.add(String.valueOf(start));
                }else{
                    String temp = start+"->"+end;
                    list.add(temp);
                }

                start = nums[i+1];
                end=nums[i+1];
            }
        }

        return list;

    }

    @Test
    public void Test(){
        int[] nums = {0,1,2,4,5,7};

        System.out.println(summaryRanges(nums));
    }
}

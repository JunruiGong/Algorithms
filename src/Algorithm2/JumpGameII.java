package Algorithm2;

import org.junit.Test;

public class JumpGameII {
    public int jump(int[] nums) {

        if(nums==null||nums.length<1){
            return 0;
        }


        int start=0;
        int end=0;
        int farthest=0;
        int result=0;
        for(int i=0;i<nums.length-1;i++){
            farthest = Math.max(farthest, nums[i]+i);

            if(i==end){
                end= farthest;
                result++;
            }
        }

        return result;
    }

    @Test
    public void test(){

        int[] nums = {2, 3, 1, 1, 4};

        jump(nums);

    }
}

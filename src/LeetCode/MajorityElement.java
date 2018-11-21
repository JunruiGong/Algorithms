package LeetCode;/*
 * LeetCode-169-Majority Element
 *
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * */

public class MajorityElement {

    public int majority(int[] num) {

        //一开始默认一个数是majority
        int major = num[0], count = 1;

        //循环查看跟major相同的数字的个数
        for (int i = 1; i < num.length; i++) {

            //如果count = 0，说明当前major个数没有数组后面的数字的个数多，将major赋值为后面的数字
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) { //如何与major相同，数量+1，否则-1
                count++;
            } else count--;

        }
        return major;
    }
}

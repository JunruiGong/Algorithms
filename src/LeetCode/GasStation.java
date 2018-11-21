package LeetCode;

/**
 * Leetcode-134-Gas Station
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * <p>
 * Example
 * Input:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * <p>
 * Output: 3
 * <p>
 * <p>
 * Input:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * <p>
 * Output: -1
 */


/**
 * https://www.cnblogs.com/boring09/p/4248482.html
 *
 * 假如从位置i开始，i+1，i+2...，一路开过来一路油箱都没有空。说明从i到i+1，i+2，...肯定是正积累。
 * 现在突然发现开往位置j时油箱空了。说明从位置i开始没法走完全程。
 * 那么，我们要从位置i+1开始重新尝试吗？不需要！为什么？因为前面已经知道，位置i肯定是正积累，
 * 那么，如果从位置i+1开始走更加没法走完全程了，因为没有位置i的正积累了。
 * 同理，也不用从i+2，i+3，...开始尝试。所以我们可以放心地从位置j+1开始尝试。
 */

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) {
            return -1;
        }

        int start = 0;  // 开始的位置
        int remain = 0; // 当前剩余燃料
        int debt = 0;   // 如果之前走的路油箱剩余为负数的话，将计算该负数的值。

        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                debt += remain;
                start = i + 1;
                remain = 0;
            }
        }

        return debt + remain >= 0 ? start : -1;
    }
}

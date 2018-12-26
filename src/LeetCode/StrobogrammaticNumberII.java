package LeetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode-247-Strobogrammatic Number II
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Find all strobogrammatic numbers that are of length = n.
 *
 * For example,
 * Given n = 2, return ["11","69","88","96"].
 *
 * Hint:
 * Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
 */
public class StrobogrammaticNumberII {

    public List<String> findStrobogrammatic(int n) {

        // 根据题意，可找到规律：
        // 后者是在前者基础上，在每个数的左右分别加上[1 1], [6 9], [8 8], [9 6]
        // 但是需要区别n为奇数还是偶数
        // 奇数情况下，是在"0", "1", "8"的基础上加；
        // 偶数情况下，是在""的情况下加。

        List<String> one = Arrays.asList("");
        List<String> two = Arrays.asList("0", "1", "8");
        List<String> result = new ArrayList<>();

        // 判断n的奇偶性，确定基础
        if (n % 2 == 1) {
            result = two;
        } else {
            result = one;
        }

        for (int i = (n % 2) + 2; i <= n; i = i + 2) {
            List<String> newList = new ArrayList<>();
            for (String str : result) {

                // 如果i == n，意味着已经加到最后一层，一个数的第一位不能是0。
                if (i != n) {
                    newList.add("0" + str + "0");
                }

                newList.add("1" + str + "1");
                newList.add("6" + str + "9");
                newList.add("8" + str + "8");
                newList.add("9" + str + "6");
            }

            result = newList;
        }

        return result;
    }
}

package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode-241-Different Ways to Add Parentheses-Medium
 *
 * Given a string of numbers and operators,
 * return all possible results from computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 *
 * Example 1:
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * Example 2:
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class DifferentWaystoAddParentheses {
    private HashMap<String, List<Integer>> hashMap = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {

        // 分治思想

        if (hashMap.containsKey(input)) {
            return hashMap.get(input);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '+' || c == '-' || c == '*') {

                // 如果c是运算符，则将字符串在c处分为左右两个子字符串，分别进行运算
                for (int left : diffWaysToCompute(input.substring(0, i))) {
                    for (int right : diffWaysToCompute(input.substring(i + 1, input.length()))) {

                        // 将字符串再次合并计算
                        if (c == '+') {
                            result.add(left + right);
                        } else if (c == '-') {
                            result.add(left - right);
                        } else {
                            result.add(left * right);
                        }
                    }
                }
            }
        }

        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }

        hashMap.put(input, result);

        return result;
    }
}

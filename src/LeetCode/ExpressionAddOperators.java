package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-282-Expression Add Operators-Hard
 *
 * Given a string that contains only digits 0-9 and a target value,
 * return all possibilities to add binary operators (not unary) +, -, or * between the digits
 * so they evaluate to the target value.
 *
 * Example 1:
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"]
 *
 * Example 2:
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 *
 * Example 3:
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 *
 * Example 4:
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 *
 * Example 5:
 * Input: num = "3456237490", target = 9191
 * Output: []
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        if (num == null || num.length() < 1) {
            return result;
        }
        help(result, num, target, 0, "", 0, 0);
        return result;

    }

    private void help(List<String> result, String num, int target, int index, String path, long evaluation, long multed) {
        if (index == num.length()) {
            if (target == evaluation) {
                result.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            // 如果起始字符为0，则跳过此次循环
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            long current = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                // 从起始位置开始，则不需要与前面的path进行运算
                help(result, num, target, i + 1, path + current, current, current);
            } else {

                help(result, num, target, i + 1, path + "+" + current, evaluation + current, current);

                help(result, num, target, i + 1, path + "-" + current, evaluation - current, -current);


                // multed 是用于出现乘法的情况下
                // 假如现在我们已经进行到 1+2+3，接下来我们需要进行 1+2+3*4
                // 我们需要先-3，再加上3*4：(1+2+3)-3+(3*4),这个时候我们就会用到multed
                help(result, num, target, i + 1, path + "*" + current, evaluation - multed + multed * current, multed * current);

            }
        }
    }
}

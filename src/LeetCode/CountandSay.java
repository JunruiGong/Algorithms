package LeetCode;


/**
 * Leetcode-38-Count and Say
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 */
public class CountandSay {
    public String countAndSay(int n) {

        int i = 1;
        String result = "1";
        while (i < n) {
            int count = 0;
            StringBuilder stringBuilder = new StringBuilder();
            char c = result.charAt(0);
            for (int j = 0; j <= result.length(); j++) {
                if (j != result.length() && c == result.charAt(j)) {
                    // 判断有几个相同的字符
                    count++;
                } else {
                    // 如result = "21"，则stringBuilder = "1211"
                    // 译为"21"里面有1个2，1个1
                    stringBuilder.append(count);
                    stringBuilder.append(c);

                    if (j != result.length()) {
                        // 如未到result末尾，则继续计算剩余字符串个数
                        count = 1;
                        c = result.charAt(j);
                    }
                }
            }

            result = stringBuilder.toString();
            i++;

        }

        return result;
    }
}

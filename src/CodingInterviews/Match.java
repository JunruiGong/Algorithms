package CodingInterviews;

/**
 * 剑指offer-53-正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {
    public boolean match(char[] str, char[] pattern) {

        if (str == null || pattern == null) {
            return false;
        }

        return matchCore(str, 0, pattern, 0);


    }

    private boolean matchCore(char[] input, int i, char[] pattern, int p) {
        if (i >= input.length && p >= pattern.length) {
            return true;
        }

        if (i != input.length && p >= pattern.length) {
            return false;

        }

        if (p + 1 < pattern.length && pattern[p + 1] == '*') {
            if (i >= input.length) {
                return matchCore(input, i, pattern, p + 2);
            } else {
                if (pattern[p] == input[i] || pattern[p] == '.') {
                    return matchCore(input, i + 1, pattern, p + 2) ||
                            matchCore(input, i + 1, pattern, p) ||
                            matchCore(input, i, pattern, p + 2);

                } else {
                    return matchCore(input, i, pattern, p + 2);
                }
            }

        }

        if (i >= input.length) {
            return false;
        } else {
            if (input[i] == pattern[p] || pattern[p] == '.') {
                return matchCore(input, i + 1, pattern, i + 1);

            }
        }

        return false;

    }
}

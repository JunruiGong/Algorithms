package LeetCode;

import java.util.Stack;

/**
 * Leetcode-71-Simplify Path-Medium
 *
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 *
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level.
 * For more information, see: Absolute path vs relative path in Linux/Unix
 *
 * Note that the returned canonical path must always begin with a slash /,
 * and there must be only a single slash / between two directory names.
 * The last directory name (if it exists) must not end with a trailing /.
 * Also, the canonical path must be the shortest string representing the absolute path.
 *
 *
 * Example 1:
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 *
 * Example 2:
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 *
 * Example 3:
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 *
 * Example 4:
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 *
 * Example 5:
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 *
 * Example 6:
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 *
 * ".": 目录
 * "..": 表示返回上一层
 *
 *
 * 路径问题大部分都可以用Stack解决
 *
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");

        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    // 返回上一层
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                // 存在目录

                stack.push(s);
            }
        }

        String res = "";
        while (!stack.isEmpty()) {
            // 从后往前进行组合
            res = "/" + stack.pop() + res;
        }

        if (res.length() == 0) {
            return "/";
        }

        return res;
    }
}
package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-257-Binary Tree Paths-Easy
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            result.add(root.val + "");
            return result;
        }

        for (String path : binaryTreePaths(root.left)) {
            result.add(root.val + "->" + path);
        }

        for (String path : binaryTreePaths(root.right)) {
            result.add(root.val + "->" + path);
        }

        return result;

    }
}

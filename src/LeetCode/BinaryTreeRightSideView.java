package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode-199-Binary Tree Right Side View-Medium
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();

            for (int i = 0; i < levelNum; i++) {
                // 与107题相似

                TreeNode tempTreeNode = queue.poll();
                if (i == 0) {
                    result.add(tempTreeNode.val);
                }

                if (tempTreeNode.right != null) {
                    queue.offer(tempTreeNode.right);
                }

                if (tempTreeNode.left != null) {
                    queue.offer(tempTreeNode.left);
                }

            }
        }

        return result;
    }
}

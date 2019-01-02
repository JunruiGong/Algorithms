package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode-102-Binary Tree Level Order Traversal-Medium
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return result;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelNum = queue.size();  // 该层节点的个数

            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < levelNum; i++) {

                // 从左至右，先后保存左节点和右节点
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }

                // 将该节点的左右子节点保存完后，删除该节点，并将该节点存入sublist中
                subList.add(queue.poll().val);
            }
            // 每个for循环结束之后，queue中只保留下一层的节点

            result.add(subList);
        }

        return result;
    }
}

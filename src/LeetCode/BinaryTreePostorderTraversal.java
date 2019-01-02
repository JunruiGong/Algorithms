package LeetCode;

import org.junit.Test;

import java.util.*;

/**
 * Leetcode-145-Binary Tree Postorder Traversal-Hard
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal {


    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {

            // 先判断该左子节点是否为null
            // 再判断右子节点
            // 最后是该节点
            if (root != null) {
                stack.push(root);
                result.addFirst(root.val); // 每次将子节点添加到result最前面
                root = root.right;  // 右子节点
            } else {
                TreeNode node = stack.pop();
                root = node.left;  // 左子节点
            }
        }

        return result;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(postorderTraversal(root));

    }
}

package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Leetcode-94-Binary Tree Inorder Traversal-Medium
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {

    // 迭代
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // 先找到最左边的子节点
                stack.push(root);
                root = root.left;
            }

            root = stack.pop(); // 取出最左边的子节点
            result.add(root.val); // 放入result中
            root = root.right;  // 再保存右节点
        }

        return result;
    }

    // 递归
    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        help(root,result);
        return result;
    }

    private void help(TreeNode root,List<Integer> result){
        if (root==null){
            return;
        }

        if (root.left!=null){
            help(root.left,result);
        }

        result.add(root.val);

        if (root.right!=null){
            help(root.right,result);
        }
    }
}

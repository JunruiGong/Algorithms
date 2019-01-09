package LeetCode;

import java.util.*;

/**
 * Leetcode-272-Closest Binary Search Tree Value II-Hard
 *
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 *
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 *
 * Hint:
 *
 * 1. Consider implement these two helper functions:
 * 　　i. getPredecessor(N), which returns the next smaller node to N.
 * 　　ii. getSuccessor(N), which returns the next larger node to N.
 * 2. Try to assume that each node has a parent pointer, it makes the problem much easier.
 * 3. Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
 * 4. You would need two stacks to track the path in finding predecessor and successor node separately.
 */
public class ClosestBinarySearchTreeValueII {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        // 采用中序遍历的思想，节点按照从小到大的顺序进行排列
        // 在deque中存放result， 值也是从小到大排列
        // 在遍历过程中，如果新的差值小于deque中最前面的值，就remove第一个数
        // 并将新的值放在队尾

        Deque<Integer> deque = new ArrayDeque<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (deque.size() < k) {
                // deque的size小于k的情况下，不需要比较差值大小，直接存入
                deque.addLast(root.val);
            } else if (Math.abs(root.val - target) < Math.abs(deque.getFirst() - target)) {
                deque.pollFirst();
                deque.addLast(root.val);
            }

            root = root.right;
        }

        List<Integer> result = new ArrayList<>(deque);

        return result;

    }
}

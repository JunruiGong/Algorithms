package LeetCode;

/**
 * Leetcode-117-Populating Next Right Pointers in Each Node II-Medium
 *
 * Given a binary tree
 *
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * Example:
 *
 * Given the following binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 *
 * 横向的指向用next表示
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {

        TreeLinkNode head = null; // 每一层的头节点
        TreeLinkNode prev = null; // 用于连接next的前一个节点
        TreeLinkNode cur = root;  // 当前节点

        while (cur != null) {
            while (cur != null) {

                // left child
                if (cur.left != null) {
                    if (prev != null) {
                        // 连接同一个父节点下面的两个子节点
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }

                    prev = cur.left;
                }

                // right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }

                    prev = cur.right;
                }

                // 向右移动一个节点
                cur = cur.next;
            }

            // 移动到下一层
            cur = head;
            head = null;
            prev = null;
        }

    }
}

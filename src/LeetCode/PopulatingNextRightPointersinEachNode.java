package LeetCode;

/**
 * Leetcode-116-Populating Next Right Pointers in Each Node-Medium
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
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * Example:
 *
 * Given the following perfect binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 *
 * 横向的指向用next表示
 */
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {

        if (root == null) {
            return;
        }

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
    }

    public void connect2(TreeLinkNode root) {

        TreeLinkNode levelStart=root;

        while (levelStart!=null){
            TreeLinkNode cur=levelStart;
            while (cur!=null){
                if (cur.left!=null){
                    cur.left.next=cur.right;
                }

                if (cur.next!=null&&cur.right!=null){
                    cur.right.next=cur.next.left;
                }

                cur=cur.next;
            }

            levelStart=levelStart.left;
        }
    }
}

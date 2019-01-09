package LeetCode;

/**
 * Leetcode-109-Convert Sorted List to Binary Search Tree-Medium
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {

        // 因为是链表，无法直接计算出中点，需要采用快慢指针的方式得到中点

        if (head == null) {
            return null;
        }

        return help(head, null);
    }

    private TreeNode help(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) {
            return null;
        }

        // 快指针走两步，慢指针走一步
        // 当快指针走到末尾时，慢指针就位于中点
        // 再以该中点为分界线，将链表分为两半继续递归
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode treeHead = new TreeNode(slow.val);
        treeHead.left = help(head, slow);
        treeHead.right = help(slow.next, tail);
        return treeHead;
    }
}

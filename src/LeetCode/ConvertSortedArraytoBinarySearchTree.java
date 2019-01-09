package LeetCode;

/**
 * Leetcode-108-Convert Sorted Array to Binary Search Tree-Easy
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {

        // 节点按照从小到大排列，可以看成是中序遍历的结果
        // 按二分法查找得到相应的节点

        if (nums == null || nums.length < 1) {
            return null;
        }

        TreeNode root = help(nums, 0, nums.length - 1);
        return root;

    }

    private TreeNode help(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = help(nums, low, mid - 1);
        node.right = help(nums, mid + 1, high);

        return node;
    }
}


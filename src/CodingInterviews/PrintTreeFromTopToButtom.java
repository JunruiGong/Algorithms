package CodingInterviews;

/**
 * 剑指offer-23-从上往下打印二叉树
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeFromTopToButtom {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        /*
        * 采用队列储存各个节点，
        * 从根节点开始，判断各个节点时候含有子树，如果有，就将子树存入队列末尾，
        * 并在队列头取出节点。
        * */

        if (root == null) {
            return null;
        }

        Queue<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(root);

        ArrayList<Integer> result = new ArrayList<Integer>();

        while (!deque.isEmpty()) {
            TreeNode tempNode = deque.remove();

            if (tempNode.right != null) {
                deque.add(tempNode.right);
            }
            if (tempNode.left != null) {
                deque.add(tempNode.left);

            }

            result.add(tempNode.val);
        }
        return result;
    }
}

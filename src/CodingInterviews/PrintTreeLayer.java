package CodingInterviews;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 剑指offer-60-把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintTreeLayer {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        // 先将根节点存入linkedlist中，然后取出并输出
        // 再判断该节点是否有左右子节点，如果有，按照从左到右的顺序也存入到linkedlist中
        // 这样就相当于是将树的每层按从左到右的顺序存放在linkedlist中。

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();

        if (pRoot == null) {
            return result;
        }

        linkedList.add(pRoot);

        int current = 1;
        int next = 0;

        while (!linkedList.isEmpty()) {

            TreeNode node = linkedList.remove();
            current--;
            temp.add(node.val);

            if (node.left != null) {
                linkedList.add(node.left);
                next++;
            }

            if (node.right != null) {
                linkedList.add(node.right);
                next++;
            }

            if (current == 0) {
                result.add(new ArrayList<Integer>(temp));
                temp.clear();
                current = next;
                next = 0;
            }
        }

        return result;


    }
}

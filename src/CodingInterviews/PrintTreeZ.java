package CodingInterviews;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 剑指offer-61-按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintTreeZ {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {


        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> eachLayer = new ArrayList<Integer>();
        if (pRoot == null) {
            return result;
        }

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> reverse = new LinkedList<TreeNode>();

        current.add(pRoot);
        int flag = 0;

        while (!current.isEmpty()) {

            // 从最后一个数开始取
            TreeNode node = current.remove(current.size() - 1);

            eachLayer.add(node.val);

            //从左往右打印
            if (flag == 0) {

                if (node.left != null) {
                    reverse.add(node.left);

                }

                if (node.right != null) {
                    reverse.add(node.right);
                }

            } else {//从右往左打印
                if (node.right != null) {
                    reverse.add(node.right);

                }

                if (node.left != null) {
                    reverse.add(node.left);
                }
            }

            if (current.isEmpty()) {
                flag = 1 - flag;
                LinkedList<TreeNode> temp = new LinkedList<TreeNode>();

                temp = reverse;
                reverse = current;
                current = temp;
                result.add(new ArrayList<Integer>(eachLayer));
                eachLayer.clear();
            }
        }

        return result;


    }
}

package CodingInterviews;

/**
 * 剑指offer-25-二叉树中和为某一值的路径
 *
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class FindPathBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

            ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();

            if (root == null) {
                return pathList;
            }

            Stack<Integer> path = new Stack<Integer>();

            findPath(root, target, path, pathList);
            return pathList;

        }

        private void findPath(TreeNode root, int target, Stack<Integer> path, ArrayList<ArrayList<Integer>> pathList) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                if (root.val == target) {


                    //两种方式遍历stack
                    // 1.使用ArrayList构造器，直接将stack放入ArrayList中
                    ArrayList<Integer> list = new ArrayList<Integer>(path);

                    //2. 使用foreach
                    //for(int i : path){
                    //    list.add(i);
                    //}
                    list.add(root.val);


                    pathList.add(list);
                }

            } else {
                path.push(root.val);
                findPath(root.left, target - root.val, path, pathList);
                findPath(root.right, target - root.val, path, pathList);
                path.pop();
            }

        }

    }
}

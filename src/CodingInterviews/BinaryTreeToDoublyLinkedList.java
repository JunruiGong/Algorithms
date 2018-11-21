package CodingInterviews;

import java.util.Stack;

/**
 * 剑指offer-27-二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class BinaryTreeToDoublyLinkedList {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) {
            return null;
        }

        //为当前数的最小数
        TreeNode newHead = null;

        //用cur记录当前节点，初始时指向根节点
        TreeNode cur = pRootOfTree;

        //preNode用来记录当前节点的前一个节点
        TreeNode preNode = null;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || cur != null) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();

            //初始时，preNode=null, 将最左边的节点赋值给newHead和preNode。
            if (preNode == null) {
                newHead = cur;
                preNode = cur;
            } else {

                //建立双向链表
                preNode.right = cur;
                cur.left = preNode;

                //将preNode移到当前节点中
                preNode = cur;
            }

            //将当前节点移动到下一个数中
            cur = cur.right;
        }


        return newHead;
    }

}


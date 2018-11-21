package CodingInterviews;

/**
 * 剑指offer-58-二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNext {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode getNext(TreeLinkNode pNode) {

        /**
         * 分两种情况：
         * 1. 如果该节点有右子树，那么中序遍历它的下一个节点就是它右子树的最左边的节点；
         * 2. 如果它没有右子树，查看该节点是其父节点的左孩子，则返回父节点，否则继续向上遍历其父节点的父节点
         */

        if (pNode == null) {
            return null;
        }

        TreeLinkNode target = null;

        if (pNode.right != null) {
            target = pNode.right;
            while (target.left != null) {
                target = target.left;
            }

            return target;
        }

        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }

            pNode = pNode.next;
        }

        return null;
    }
}

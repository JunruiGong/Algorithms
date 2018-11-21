package CodingInterviews;

import java.util.Stack;

/**
 * 剑指offer-37-两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 */

public class FindFirstCommonNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    // 用两个stack分别存放链表，从栈顶取出数据比较是否相同，找到最后一个相同的节点
    // 该节点就是链表中第一个相同的节点
    public ListNode findFirstCommonNode1(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();


        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode commonNode = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek().equals(stack2.peek())) {
                commonNode = stack1.peek();
                stack1.pop();
                stack2.pop();
            } else {
                break;
            }
        }

        return commonNode;

    }


    // 先确定两个链表的长度，再将长链表遍历到与短链表长度相同，然后再同时遍历
    // 就可找到第一个相同的节点
    public ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);

        int diff = length1 - length2;

        ListNode longListHead = null;
        ListNode shortListHead = null;
        if (diff >= 0) {
            longListHead = pHead1;
            shortListHead = pHead2;
        } else {
            longListHead = pHead2;
            shortListHead = pHead1;
        }

        for (int i = 0; i < diff; i++) {
            longListHead = longListHead.next;
        }

        while (longListHead != null && shortListHead != null && longListHead.val != shortListHead.val) {
            longListHead = longListHead.next;
            shortListHead = shortListHead.next;
        }

        return longListHead;


    }

    private int getLength(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }

        return length;

    }
}

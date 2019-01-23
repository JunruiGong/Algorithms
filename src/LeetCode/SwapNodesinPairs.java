package LeetCode;

/**
 * Leetcode-24-Swap Nodes in Pairs-Medium
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 *
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 * l1 -> 1 -> 2 -> 3 -> 4
 *      l2
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;

        while (l2 != null && l2.next != null) {
            ListNode nextStart = l2.next.next;

            // 完成交换
            l1.next = l2.next;
            l2.next.next = l2;

            l2.next = nextStart;
            l1 = l2;
            l2 = l2.next;

            // 此时的链表：
            // 2 -> 1 -> 3 -> 4
            //      l1   l2
        }

        return dummy.next;
    }
}

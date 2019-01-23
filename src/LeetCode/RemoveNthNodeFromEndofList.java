package LeetCode;

/**
 * Leetcode-19-Remove Nth Node From End of List-Medium
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 *
 *   dummy -> 1 -> 2 -> 3 -> 4 -> 5
 *
 *
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }


        // 此时：
        // dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> null
        //   s                f

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // while循环结束：
        // dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> null
        //                    s                f
        // slow走到需要删除的节点的前一个

        // 删除slow.next的节点
        slow.next = slow.next.next;
        return dummy.next;
    }
}

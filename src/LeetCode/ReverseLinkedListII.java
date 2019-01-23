package LeetCode;

/**
 * Leetcode-92-Reverse Linked List II-Medium
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 *  1 -> 2 -> 3 -> 4 -> 5 -> NULL
 *  p    c    n
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode curr = head;

        // 找到起始翻转的位置
        for (int i = 1; i < m; i++) {
            pre = pre.next;
            curr = curr.next;
        }

        ListNode next = null;

        for (int i = 0; i < n - m; i++) {
            next = curr.next;  // next = 3
            curr.next = next.next;  // 2 -> 4
            next.next = pre.next;   // 3 -> 2
            pre.next = next;     // 1 -> 3

            // 一次循环之后，翻转一次
            // 1 -> 3 -> 2 -> 4 -> 5
        }

        return dummy.next;
    }
}

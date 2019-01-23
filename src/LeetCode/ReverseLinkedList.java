package LeetCode;

/**
 * Leetcode-206-Reverse Linked List-Easy
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;  // Save next node
            curr.next = prev;  // Reverse node
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Recursion
    public ListNode reverseList2(ListNode head) {

        // If the head is last one, return it
        if (head == null || head.next == null) {
            return head;
        }

        // Find the last node
        ListNode reverseListHead = reverseList2(head.next);

        head.next.next = head;
        head.next = null;
        return reverseListHead;
    }
}

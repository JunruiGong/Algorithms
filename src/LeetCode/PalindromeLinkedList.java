package LeetCode;

/**
 * Leetcode-234-Palindrome Linked List-Easy
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到链表的中点
        ListNode middle = findMiddle(head);

        // 从中点开始将链表反转
        ListNode reverseHead = reverse(middle);

        // 依次比较两个子链表的大小
        while (reverseHead != null) {
            if (head.val != reverseHead.val) {
                return false;
            } else {
                head = head.next;
                reverseHead = reverseHead.next;
            }
        }

        return true;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // fast走的速度是slow的两倍，所以当fast走到最后的时候
        // slow只走了一半
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}

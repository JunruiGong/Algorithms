package LeetCode;

/**
 * Leetcode-21-Merge Two Sorted Lists-Easy
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }

            curr = curr.next;
        }

        // 循环结束的条件肯定是其中的l1或者l2结束到末尾了
        // 如果l1 != null, 说明l1中还有剩余的值，将这些值全部加到curr之后
        if (l1 != null) {
            curr.next = l1;
        } else {
            // 说明是l2没有结束完，与l1操作相似
            curr.next = l2;
        }

        return dummy.next;
    }
}
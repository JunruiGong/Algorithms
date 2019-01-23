package LeetCode;

/**
 * Leetcode-82-Remove Duplicates from Sorted List II-Medium
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 *
 *      0 -> 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
 *    dummy
 *    curr
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {

            // 找到相同的值
            if (curr.next.val == curr.next.next.val) {

                // 记录下相同的值
                int sameNum = curr.next.val;

                // 删除所有相同的值
                while (curr.next != null && curr.next.val == sameNum) {
                    curr.next = curr.next.next;
                }
            } else {
                // 向下移动
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}

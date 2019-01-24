package LeetCode;

/**
 * Leetcode-86-Partition List-Medium
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 *      1->4->3->2->5->2
 *      smallHead->1->2->2->
 *      bigHead->4->3->5->
 *
 *
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode smallHead = new ListNode(0),
                bigHead = new ListNode(0),
                small = smallHead,
                big = bigHead;

        while (head != null) {
            ListNode temp = new ListNode(head.val);
            if (head.val < x) {
                small.next = temp;
                small = small.next;
            } else {
                big.next = temp;
                big = big.next;
            }
            head = head.next;
        }

        small.next = bigHead.next;
        return smallHead.next;
    }
}

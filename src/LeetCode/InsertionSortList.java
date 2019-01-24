package LeetCode;

/**
 * Leetcode-147-Insertion Sort List-Medium
 *
 * Sort a linked list using insertion sort.
 *
 *
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 *
 *
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data,
 * finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;


        while (curr != null && curr.next != null) {

            // 符合递增的顺序，移动到下一个
            if (curr.val <= curr.next.val) {
                curr = curr.next;
            } else {
                // 不符合递增的顺序，记录这个需要移动的点
                temp = curr.next;

                // 将curr直接连接到下下个节点，跳过需要移动的点
                curr.next = curr.next.next;
                prev = dummy;

                // 找到放置temp的位置
                while (prev.next.val <= temp.val) {
                    prev = prev.next;
                }

                // 将temp插入其中
                temp.next = prev.next;
                prev.next = temp;
            }
        }

        return dummy.next;
    }
}

package LeetCode;

/**
 * Leetcode-2-Add Two Numbers-Medium
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        int sum = 0; // 表示每两个数相加的和

        ListNode cur = dummy; // 用于组成新的链表

        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            // 将l1和l2上的两个数相加得到sum

            // 在新的链表上赋值
            cur.next = new ListNode(sum % 10);

            // 如果sum>10则会有进位，将进位用于下一个循环
            sum = sum / 10;

            // 链表下移
            cur = cur.next;
        }

        // 如果循环结束，sum=1，说明是上一个循环还有进位，
        // 则需要在链表最后添加1这个节点
        if (sum == 1) {
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }
}

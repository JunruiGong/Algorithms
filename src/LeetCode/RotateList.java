package LeetCode;

/**
 * Leetcode-61-Rotate List-Medium
 *
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 * Example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null){
            return head;
        }

        ListNode index = head;
        int len = 1;

        // 得到链表的长度
        while (index.next!=null){
            index=index.next;
            len++;
        }

        // 形成环路
        index.next=head;

        // 找到需要断开的位置
        for (int i=1;i<len-k%len;i++){
            head=head.next;
        }

        ListNode res = head.next;
        head.next=null;

        return res;
    }
}

package LeetCode;


/**
 * Leetcode-148-Sort List-Medium
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }

        ListNode prev = null;
        ListNode fast=head;
        ListNode slow=head;

        // 找到链表的中点，分为两半
        while (fast!=null&&fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }

        prev.next=null;

        // 对分开后的链表进行排序
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // 然后合并两个子链表
        return merge(l1,l2);
    }


    // 合并两个子链表
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1!=null&&l2!=null){
            if (l1.val < l2.val) {
                curr.next=l1;
                l1=l1.next;
            }else{
                curr.next=l2;
                l2=l2.next;
            }

            curr=curr.next;
        }

        if (l1!=null){
            curr.next=l1;
        }
        if (l2!=null){
            curr.next=l2;
        }

        return dummy.next;
    }
}

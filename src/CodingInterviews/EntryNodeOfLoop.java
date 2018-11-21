package CodingInterviews;

/**
 * 剑指offer-56-链表中环的入口结点 (LeetCode--142)
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;
        boolean flag = false;


        while (fast != null && slow != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }

            fast = fast.next.next;

            if (fast == slow) {
                flag = true;
                break;
            }
        }

        if (flag != true) {
            return null;
        } else {
            fast = pHead;

            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            return fast;

        }

    }
}

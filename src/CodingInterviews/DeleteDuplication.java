package CodingInterviews;

/**
 * 剑指offer-57-删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        //只有一个节点
        if (pHead.next == null) {
            return pHead;
        }

        //临时头节点
        ListNode root = new ListNode(0);
        root.next = pHead;

        //记录前驱节点
        ListNode prev = root;

        //记录当前节点
        ListNode node = pHead;

        while (node != null && node.next != null) {

            // 存在重复节点
            if (node.val == node.next.val) {
                while (node.next != null && node.next.val == node.val) {
                    node = node.next;
                }

                prev.next = node.next;
            } else {//不是重复节点
                prev.next = node;
                prev = prev.next;
            }
            node = node.next;
        }
        return root.next;
    }
}

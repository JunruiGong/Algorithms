package CodingInterviews;

/**
 * 剑指offer-26-复杂链表的复制
 *
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * */

import java.util.HashMap;

public class CloneLinkList {

    public class RandomListNode {

        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }


    public RandomListNode Clone(RandomListNode pHead) {


        if (pHead == null) {
            return null;
        }

        HashMap<RandomListNode, RandomListNode> oldToNew = new HashMap<>();
        RandomListNode newHead = new RandomListNode(pHead.label);
        oldToNew.put(pHead, newHead);
        RandomListNode cur = pHead.next;
        RandomListNode newCur = null;
        RandomListNode newCurPrev = newHead;

        while (cur != null) {
            newCur = new RandomListNode(cur.label);
            oldToNew.put(cur, newCur);
            newCurPrev.next = newCur;
            newCurPrev = newCurPrev.next;
            cur = cur.next;
        }

        cur = pHead;
        newCur = newHead;

        while (cur != null) {
            if (cur.random != null) {
                newCur.random = oldToNew.get(cur.random);
            }
            cur = cur.next;
            newCur = newCur.next;
        }


        return newHead;
    }

}

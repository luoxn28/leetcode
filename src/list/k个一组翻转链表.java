package list;

import list.util.ListNode;

/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 解法
 * 1 从头开始遍历链表，以k为单位，将这k个节点反转，
 */
public class k个一组翻转链表 {

    public static void main(String[] args) {
        ListNode head = ListNode.newListNode();

        System.out.println(reverseKGroup(head, 13));
    }

    static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }
        if (k > length) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        for (ListNode cur = head; cur != null;) {

            // 将k为单位的子链表反转
            ListNode subHead = new ListNode(-1);
            subHead.next = cur;
            ListNode tail = cur;
            cur = cur.next;
            for (int i = 1; i < k && cur != null; i++) {
                ListNode next = cur.next;
                cur.next = subHead.next;
                subHead.next = cur;
                cur = next;
            }

            tail.next = null;
            if (cur != null) {
                prev.next = subHead.next;
                prev = tail;
            } else {
                // 最后一个子节点列表，再对其进行逆序挂到原链表结尾
                ListNode subCur = subHead.next;
                while (subCur != null) {
                    ListNode next = subCur.next;
                    subCur.next = prev.next;
                    prev.next = subCur;
                    subCur = next;
                }
            }
        }

        return dummy.next;
    }
}

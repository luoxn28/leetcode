package list;

import list.util.ListNode;

/**
 * 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 解法
 * 1 按照快慢指针将链表分为前后两个子链表，将后半部分的子链表反转，然后将二者合并
 */
public class 重排链表 {

    public static void main(String[] args) {
//        ListNode head = ListNode.newListNode();
//
//        reorderList(head);
//        System.out.println(head);

        ListNode h1 = ListNode.newListNode();
        ListNode h2 = reverse(ListNode.newListNode());
        System.out.println(mergeList(h1, h2));
    }

    static ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode cur1 = head1, cur2 = head2;
        while (cur1.next != null && cur2.next != null) {
            ListNode next1 = cur1.next;
            ListNode next2 = cur2.next;
            cur1.next = cur2;
            cur2.next = next1;

            cur1 = next1;
            cur2 = next2;
        }

        cur1.next = cur2;
        return head1;
    }

    static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head, prev = null;
        while (slow != null && fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 切分链表 反转后半部分链表
        prev.next = null;
        slow = reverse(slow);

        // 两个链表合并
        ListNode cur = head;
        while (cur.next != null) {
            ListNode curNext = cur.next;
            ListNode slowNext = slow.next;
            cur.next = slow;
            slow.next = curNext;

            cur = curNext;
            slow = slowNext;
        }
        cur.next = slow;
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null;

        for (ListNode cur = head; cur != null;) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

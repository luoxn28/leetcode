package list;

import list.util.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 解法
 * 1 遍历链表，相当于一次遍历2个节点，然后针对这2个节点做反转操作，需要记录这两个节点的前一个节点prev
 */
public class 两两交换链表中的节点 {

    public static void main(String[] args) {
        ListNode head = ListNode.newListNode();

        System.out.println(swapPairs(head));
    }

    static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (ListNode prev = dummy, cur = head; cur != null;) {
            ListNode next = cur.next;
            if (next == null) {
                break;
            }

            cur.next = next.next;
            next.next = cur;
            prev.next = next;

            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}

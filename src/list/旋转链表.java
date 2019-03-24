package list;

import list.util.ListNode;

/**
 * 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数
 *
 * 解法
 * 1 先求出链表长度，对k取余，链表右移k个位置，相当于以第（length - k）个节点为首节点的链表一样
 */
public class 旋转链表 {

    public static void main(String[] args) {
        ListNode head = ListNode.newListNode();

        System.out.println(rotateRight(head, 5));
    }

    static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        k %= length;
        k = length - k;
        tail.next = head;

        ListNode prev = tail;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            prev = cur;
            cur = cur.next;
        }

        prev.next = null;
        return cur;
    }
}

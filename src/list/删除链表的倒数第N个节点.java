package list;

import list.util.ListNode;

/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 解法
 * 1 定义2个指针 p q，让q先走n步，然后p q一起走，知道q到达链表纬度，此时p对应就是倒数第n个节点
 */
public class 删除链表的倒数第N个节点 {

    public static void main(String[] args) {
        ListNode head = ListNode.newListNode();

        System.out.println(removeNthFromEnd(head, 5));
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy, q = dummy;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        while (q.next != null) {
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;

        return dummy.next;
    }
}

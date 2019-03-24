package list;

import list.util.ListNode;

/**
 * 反转链表
 *
 * 解法：
 * 1 循环更改节点前后关系
 * 2 递归更改节点前后关系，注意结束边界条件
 */
public class 反转链表 {

    public static void main(String[] args) {
        ListNode head = ListNode.newListNode();

        System.out.println(head);
        System.out.println(head = reverseList(head));
        System.out.println(reverseList2(head));
    }

    // 解法1 循环更改节点前后关系
    static ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // 解法2 递归更改节点前后关系
    static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList2(next);
        next.next = head;

        return newHead;
    }
}



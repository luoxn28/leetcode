package list;

import list.util.ListNode;

/**
 * 回文链表
 *
 * 解法
 * 1 根据快慢节点找到中心节点，然后反转链表后半部分节点，然后比较前后两个节点
 */
public class 回文链表 {

    static boolean isPalindrome(ListNode head) {
        // slow为中间节点
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半部分链表，然后比较两个链表
        slow = reverse(slow);
        while (head != null && slow != null && head.val == slow.val) {
            head = head.next;
            slow = slow.next;
        }
        return slow == null;
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

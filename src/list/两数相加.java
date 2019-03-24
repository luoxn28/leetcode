package list;

import list.util.ListNode;

/**
 * 两数相加
 *
 * 解法：
 * 1 从头遍历l1、l2，使用carry作为进位，如果遍历完成之后carry>0，则新建一个节点
 */
public class 两数相加 {

    public static void main(String[] args) {
        ListNode l1 = ListNode.newListNode();
        ListNode l2 = ListNode.newListNode();

        System.out.println(addTwoNumbers(l1, l2));
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);

        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val: 0);
            carry = num / 10;
            cur.next = new ListNode(num % 10);
            cur = cur.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return head.next;
    }
}

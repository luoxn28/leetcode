package list;

import list.util.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class 分隔链表 {

    public static void main(String[] args) {
        ListNode head = 反转链表.reverseList(ListNode.newListNode());

        System.out.println(head);
        System.out.println(partition(head, 3));
    }

    static ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(-1);
        ListNode rightHead = new ListNode(-1);
        ListNode left = leftHead;
        ListNode right = rightHead;

        for (; head != null; head = head.next) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
        }
        right.next = null;
        left.next = rightHead.next;
        return leftHead.next;
    }
}

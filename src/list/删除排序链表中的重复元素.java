package list;

import list.util.ListNode;

/**
 * 删除排序链表中的重复元素
 *
 * 解法
 * 1 遍历链表，当前节点与prev节点一样时，prev.next = cur.next; cur = cur.next;
 */
public class 删除排序链表中的重复元素 {

    public static void main(String[] args) {
        ListNode node = ListNode.newListNode();
        ListNode head = new ListNode(1);
        head.next = node;

        System.out.println(head);
        System.out.println(deleteDuplicates(head));
    }

    static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        for (ListNode prev = head, cur = head.next; cur != null; cur = cur.next) {
            if (prev.val != cur.val) {
                prev = cur;
            } else {
                prev.next = cur.next;
            }
        }
        return head;
    }
}

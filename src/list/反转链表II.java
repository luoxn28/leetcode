package list;

import list.util.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 说明：1 ≤ m ≤ n ≤ 链表长度。
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 解法：
 * 1 思路就是反转m到n的节点，不过需要保存m点之前的那个节点，和n点之后的节点，用于更新原链表和m-n反转链表的前后关系
 */
public class 反转链表II {

    public static void main(String[] args) {

        System.out.println(reverseBetween(ListNode.newListNode(), 2, 4));
        System.out.println(reverseBetween(ListNode.newListNode(), 1, 5));
        System.out.println(reverseBetween(ListNode.newListNode(), 1, 3));
        System.out.println(reverseBetween(ListNode.newListNode(), 2, 5));
    }

    static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode prev = newHead;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }

        ListNode head2 = prev;
        ListNode cur = prev.next;
        for (int i = m; i <= n; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head2.next.next = cur;
        head2.next = prev;
        return newHead.next;
    }
}

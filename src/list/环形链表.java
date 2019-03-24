package list;

import list.util.ListNode;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 解法
 * 1 使用2个指针，慢的指针每次增加1个单位，快的指针每次增加2个单位，如果快的赶上了慢的，说明有环
 */
public class 环形链表 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        System.out.println(hasCycle(n1));
        n3.next = n2;
        System.out.println(hasCycle(n1));
    }

    static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

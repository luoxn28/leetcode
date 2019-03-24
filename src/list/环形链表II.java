package list;

import list.util.ListNode;

/**
 * 环形链表II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 解法
 * 1 快慢2个指针，相遇时，另一个指针slow2从head开始，每次和slow步调一致，二者相遇时就是链表入环的第一个节点
 */
public class 环形链表II {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n2;

        System.out.println(detectCycle(n1).val);
    }

    static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }

        return null;
    }
}

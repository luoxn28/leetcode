package list.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表节点
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(val);

        ListNode tmp = next;
        while (tmp != null) {
            builder.append(" -> " + tmp.val);
            tmp = tmp.next;
        }
        return builder.toString();
    }

    public static ListNode newListNode() {
        ListNode prev = new ListNode(5);
        for (int i = 4; i >= 1; i--) {
            ListNode listNode = new ListNode(i);
            listNode.next = prev;
            prev = listNode;
        }

        return prev;
    }
}

package list;

import list.util.ListNode;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 解法：
 * 1 创建两个新的空链表，遍历原始链表，把奇数位置的节点添加到第一个小链表，把偶数位置的节点添加到第二个小链表。
 *   最后将第二个小链表拼接在第一个小链表后即可。
 */
public class 奇偶节点 {

    public static void main(String[] args) {
        ListNode head1 = ListNode.newListNode();

        System.out.println(oddEvenList(head1));
    }

    static ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode odd = oddHead;
        ListNode even = evenHead;

        boolean oddFlag = true;
        while (head != null) {
            if (oddFlag) {
                odd.next = head;
                odd = head;
            } else {
                even.next = head;
                even = head;
            }

            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
            oddFlag = !oddFlag;
        }

        odd.next = evenHead.next;
        return oddHead.next;
    }
}

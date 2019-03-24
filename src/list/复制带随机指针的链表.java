package list;

/**
 * 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * 解法
 * 1 遍历链表，针对每个节点，构造一个等值节点插入该节点后面；再次遍历链表，更新random指针；再次遍历链表，将新老节点分离
 */
public class 复制带随机指针的链表 {

    public static void main(String[] args) {
    }

    public Node copyRandomList(Node head) {
        // 构造节点，插入到原链表中
        for (Node cur = head; cur != null;) {
            Node node = new Node(cur.val, cur.next, null);
            cur.next = node;
            cur = node.next;
        }

        // 新构造节点random指针赋值
        for (Node cur = head; cur != null;) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 链表分离
        Node dummy = new Node(-1, null, null);
        for (Node cur = head, prev = dummy; cur != null;) {
            prev.next = cur.next;
            prev = cur.next;

            // 恢复老链表关系
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}
        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}

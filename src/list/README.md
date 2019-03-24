## 链表类型

### 反转链表
反转链表思路是：遍历链表，使用prev指针表示当前遍历节点的前一个节点，遍历过程中更改节点前后关系，遍历完时就完成了翻转链表。比如反转整个链表、反转链表中部分节点、以K个节点为组反转链表、旋转链表。
leetcode相关题目：[反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)、[反转链表 II](https://leetcode-cn.com/problems/reverse-linked-list-ii/)、[旋转链表](https://leetcode-cn.com/problems/rotate-list/)

反转整个链表代码：
```java
ListNode reverseList(ListNode head) {
    ListNode prev = null;

    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
```

### 分隔链表
找到链表中某个节点，然后从该节点将其分隔。比如使用快慢指针（快指针每次走2个单位，慢指针每次走1个单位），可以找到中间节点位置；针对节点val做比较，遍历节点，将节点分为两部分；或者将奇偶节点分离。
leetcode相关题目：[奇偶链表](https://leetcode-cn.com/problems/odd-even-linked-list/)、[分隔链表](https://leetcode-cn.com/problems/partition-list/)

使用快慢指针找到中心节点代码：
```java
ListNode slow = head, fast = head, prev = null;
while (slow != null && fast != null && fast.next != null) {
    prev = slow;
    slow = slow.next;
    fast = fast.next.next;
}
```

### 环形链表
判断环形链表主要思虑就是使用快慢指针，当快慢指针相等时，表示链表有环，否则无环。如果有环，可以获取链表入环的第一个节点。
leetcode相关题目：[环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)、[环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

判断链表是否有环：
```java
boolean hasCycle(ListNode head) {
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
```

### 合并链表
同时开始遍历两个链表，将他们二者当前遍历节点“合并”到一起。比如两个链表相加、两个链表合并。
leetcode相关题目：[两数相加](https://leetcode-cn.com/problems/add-two-numbers/)

合并两个链表：
```java
ListNode mergeList(ListNode head1, ListNode head2) {
    ListNode cur1 = head1, cur2 = head2;
    while (cur1.next != null && cur2.next != null) {
        ListNode next1 = cur1.next;
        ListNode next2 = cur2.next;
        cur1.next = cur2;
        cur2.next = next1;

        cur1 = next1;
        cur2 = next2;
    }

    cur1.next = cur2;
    return head1;
}
```
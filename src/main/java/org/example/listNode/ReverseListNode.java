package org.example.listNode;

/**
 * @Auther: Kenfeng
 * @Date: 2023/01/08/下午3:00
 * @Description: 反转链表的不同解法
 */
public class ReverseListNode {

    /**
     * 206. 反转链表  递归解法
     * @param head
     * @return
     */
    public ListNode reverseListWithecurrence(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseListWithecurrence(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    /**
     * 206. 反转链表 迭代解法
     * @param head
     * @return
     */
    public ListNode reverseListWithIteration(ListNode head) {
        ListNode previous = null;
        ListNode current, next;
        current = head;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    /**
     * 反转前n个节点
     * @param head
     * @param n
     * @return
     */
    ListNode successor = null;
    ListNode reverseN(ListNode head, int n){
        if(n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = successor;

        return last;
    }

    /**
     * 92. 反转链表 II
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left -1, right - 1);
        return head;
    }

    /**
     * 25. K 个一组翻转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        ListNode a, b;
        a= b = head;
        for(int i=0;i<k;i++) {
            if(b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverseNode(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }

    private ListNode reverseNode(ListNode a, ListNode b) {
        ListNode previous = null;
        ListNode current, next;
        current = a;
        while (current != b) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    /**
     * 24. 两两交换链表中的节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }



}

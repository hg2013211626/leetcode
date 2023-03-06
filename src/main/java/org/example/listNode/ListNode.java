package org.example.listNode;

/**
 * @Auther: Kenfeng
 * @Date: 2023/01/02/上午11:19
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

package org.example.listNode;

import java.util.PriorityQueue;

/**
 * @Auther: Kenfeng
 * @Date: 2023/01/02/下午2:33
 * @Description:
 */
public class Solution {
    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     * @param head
     * @param k
     * @return
     */

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i=0;i<k;i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }


    /**
     * 19. 删除链表的倒数第 N 个结点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode x = getKthFromEnd(dumpy, n+1);
        x.next = x.next.next;
        return dumpy.next;
    }


    /**
     * 21. 合并两个有序链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p =dummy;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            if(p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            }else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if(p1 != null) {
            p.next = p1;
        }else if(p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

    /**
     * 23. 合并K个升序链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dumpy = new ListNode(-1);
        ListNode p = dumpy;
        if(lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));
        for(ListNode head : lists) {
            if(head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if(node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }
        return dumpy.next;
    }

    /**
     * 86. 分隔链表
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode minDumpy = new ListNode(-1);
        ListNode maxDumpy = new ListNode(-1);
        ListNode minP = minDumpy;
        ListNode maxP = maxDumpy;
        ListNode p = head;
        while (p != null) {
            if(p.val < x) {
                minP.next = p;
                minP = minP.next;
            } else {
                maxP.next = p;
                maxP = maxP.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
//            p = p.next;
        }
        minP.next = maxDumpy.next;
        return minDumpy.next;
    }

    /**
     * 141. 环形链表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow =slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 142. 环形链表 II
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow =slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(null == fast || null == fast.next) {
            return null;
        }
        slow = head;
        while (slow != head) {
            slow = slow.next;
            head = head.next;
        }
        return slow;
    }


    /**
     * 160. 相交链表
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if(p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if(p2 == null) {
                p2= headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    /**
     * 876. 链表的中间结点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow =slow.next;
        }
        return slow;

    }

    /**
     * 83. 删除排序链表中的重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if(slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }




}

package linkedlist.ReverseLinkedList;

// https://leetcode.com/problems/reverse-linked-list/description/
/**
 * ReverseLinkedList
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        ListNode next = head.next;

        current.next = null;

        while (current != null) {
            if (next == null) {
                return current;
            }

            ListNode secondNext = next.next;

            next.next = current;

            current = next;

            next = secondNext;
        }
        return null;
    }
}

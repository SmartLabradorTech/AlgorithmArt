package linkedlist.ReverseLinkedList;

public class ReverseLinkedListV3 {

    // clean version without addtional helper function.

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode next = head.next;

        if (next == null) {
            return head;
        }

        ListNode newHead = reverseList(next);

        if (next != null) {
            head.next = null;
            next.next = head;
        }

        return newHead;
    }
}

class ListNode {
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
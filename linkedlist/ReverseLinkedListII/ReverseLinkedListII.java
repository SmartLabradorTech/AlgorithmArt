package linkedlist.ReverseLinkedListII;

// https://leetcode.com/problems/reverse-linked-list-ii/

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode current = head;
        ListNode next = current.next;

        ListNode leftGuardNode = null;

        ListNode innerTail = null;

        for (int count = 0;;) {
            count++;

            if (count == left - 1) {
                leftGuardNode = current;
            }

            if (count < left) {
                current = next;
                next = current.next;
            } else if (count >= left && count < right) {

                if (count == left) {
                    innerTail = current;
                }

                ListNode secondNext = next.next;

                next.next = current;

                current = next;

                next = secondNext;
            } else if (count == right) {
                innerTail.next = next;
                if (leftGuardNode == null) {
                    return current;
                }

                leftGuardNode.next = current;
                current = next;

            } else {
                break;
            }

        }

        return head;
    }

    public static void main(String[] args) {

        ReverseLinkedListII rd = new ReverseLinkedListII();

        ListNode node1 = new ListNode(5);

        ListNode node2 = new ListNode(4, node1);

        ListNode node3 = new ListNode(3, node2);

        ListNode node4 = new ListNode(2, node3);

        ListNode node5 = new ListNode(1, node4);

        ListNode node = rd.reverseBetween(node5, 2, 4);

        while (node != null) {
            System.out.println(node.val);

            node = node.next;
        }

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

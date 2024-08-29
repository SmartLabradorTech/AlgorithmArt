package linkedlist.ReverseLinkedListII;

// use recursion to solve.

public class ReverseLinkedListIIV2 {

    private ListNode innerHead = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {

        innerHead = findHead(head, right);
        return null;
    }

    private ListNode findHead(ListNode head, int right) {

        ListNode node = head;
        ListNode previous = null;
        int count = 0;

        while (count < right) {

            count++;

            previous = node;

            node = node.next;
        }

        return previous;
    }

    private ListNode reverse(ListNode node, ListNode previous, int count, int left, int right) {

        if (count <= left - 1) {
            return reverse(node.next, node, count + 1, left, right);
        }

        if (count == left) {

            ListNode tail = reverse(node.next, node, count + 1, left, right);

            if (previous != null) {

            }

        }

        return null;
    }

}

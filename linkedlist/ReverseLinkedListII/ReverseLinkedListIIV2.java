package linkedlist.ReverseLinkedListII;

// use recursion to solve.

public class ReverseLinkedListIIV2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }

        return reverseBetween(head, 1, head, left, right);
    }

    private ListNode reverseBetween(ListNode oldHead, int step, ListNode node, int left, int right) {

        if (step < left - 1) {

            reverseBetween(oldHead, step + 1, node.next, left, right);

            return oldHead;
        }

        if (step == left - 1) {

            ListNode innerHead = node;

            ListNode subHead = reverseBetween(oldHead, step + 1, node.next, left, right);

            innerHead.next = subHead;

            return oldHead;
        }

        if (step >= left && step < right) {

            ListNode next = node.next;

            ListNode subHead = reverseBetween(oldHead, step + 1, next, left, right);

            ListNode temp = next.next;

            next.next = node;

            node.next = temp;

            return subHead;
        }

        return node;
    }

}

package linkedlist.ReverseLinkedListII;

// rewrite iteration.

public class ReverseLinkedListIIV4 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode current = head;
        ListNode next = head.next;

        ListNode beforeChange = null;
        ListNode firstChange = null;

        while (left <= right) {

            if (left != 1) {
                beforeChange = current;
                next = current.next;

                current = next;

                left--;
                right--;
            } else {
                if (firstChange == null) {
                    firstChange = current;
                }

                ListNode temp = next == null ? null : next.next;
                next.next = current;

                current = next;
                next = temp;

                right--;
            }

        }

        // when existing
        if (beforeChange == null) {
            // reverve from the first node.
            firstChange.next = next;
            return current;
        }

        firstChange.next = next;

        beforeChange.next = current;

        return head;
    }
}

package linkedlist.ReverseLinkedListII;

// a simple recursion without addtional helper function.

public class ReverseLinkedListIIV3 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }

        if (left != 1) {
            // the current node do not reverse.

            ListNode subHead = reverseBetween(head.next, left - 1, right - 1);

            head.next = subHead;

            return head;
        }

        ListNode next = head.next;

        ListNode subHead = reverseBetween(next, 1, right - 1);

        ListNode temp = next.next;

        head.next = temp;

        next.next = head;

        return subHead;
    }

}

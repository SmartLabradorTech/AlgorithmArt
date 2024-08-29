package string.PalindromeLinkedList;

/**
 * PalindromeLinkedListV2
 */
public class PalindromeLinkedListV2 {
    public boolean isPalindrome(ListNode head) {

        int length = 0;

        ListNode node = head;

        while (node != null) {
            length++;
            node = node.next;
        }

        if (length == 1) {
            return true;
        }

        int splitStart = 0;
        if (length % 2 == 0) {
            splitStart = length / 2 + 1;
        } else {
            splitStart = length / 2 + 2;
        }

        ListNode targetNode = find(head, splitStart);

        ListNode newHead = reverse(targetNode);

        for (int i = 0; i < length / 2; i++) {
            if (head == null || newHead == null || head.val != newHead.val) {
                return false;
            }

            head = head.next;
            newHead = newHead.next;

        }

        return true;
    }

    private ListNode find(ListNode head, int splitStart) {
        int findCount = 0;
        ListNode node = head;

        while (node != null) {

            findCount++;

            if (findCount == splitStart) {
                return node;
            }

            node = node.next;
        }

        return null;
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode next = current.next;

        while (current != null) {
            if (next == null) {
                // current is already the last.
                return current;
            }

            ListNode secondNext = next.next;
            next.next = current;
            current = next;
            next = secondNext;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(2, node1);

        ListNode node3 = new ListNode(3, node2);

        ListNode node4 = new ListNode(4, node3);

        ListNode node5 = new ListNode(2, node4);

        ListNode node6 = new ListNode(3, node5);

        ListNode node7 = new ListNode(1, node6);

        PalindromeLinkedListV2 pt = new PalindromeLinkedListV2();

        // ListNode node1 = new ListNode(2);
        // ListNode node2 = new ListNode(1, node1);

        System.out.println(pt.isPalindrome(node7));

    }

}

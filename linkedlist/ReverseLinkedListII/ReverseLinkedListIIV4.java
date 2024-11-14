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

        while (left < right) {

            if (left != 1) {
                beforeChange = current;
                current = next;
                next = current.next;

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

    public static void main(String[] args) {

        ReverseLinkedListIIV4 rd = new ReverseLinkedListIIV4();

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

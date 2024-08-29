package linkedlist.ReverseLinkedList;

public class ReverseLinkedListV2 {

    // use recursion.

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = findTail(head);

        reverse(head);
        head.next = null;
        return newHead;
    }

    // return tail of reversed list.
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = reverse(head.next);

        tail.next = head;

        return head;
    }

    private ListNode findTail(ListNode head) {
        ListNode node = head;
        ListNode previous = null;

        while (node != null) {
            previous = node;
            node = node.next;
        }

        return previous;
    }

    public static void main(String[] args) {
        ReverseLinkedListV2 re = new ReverseLinkedListV2();

        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(1, node4);

        ListNode reversed = re.reverseList(node5);

        while (reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
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

package string.PalindromeLinkedList;

// https://leetcode.com/problems/palindrome-linked-list/description/

public class PalindromeLinkedList {

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

        ListNode newHead = reverse(targetNode)[0];

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

    private ListNode[] reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            ListNode[] result = new ListNode[2];

            // head
            result[0] = head;

            // tail
            result[1] = head;

            return result;
        }

        ListNode[] resultForRest = reverse(head.next);

        resultForRest[1].next = head;

        head.next = null;

        ListNode[] result = new ListNode[2];

        result[0] = resultForRest[0];
        result[1] = head;

        return result;
    }

    public static void main(String[] args) {
        // ListNode node1 = new ListNode(1);

        // ListNode node2 = new ListNode(2, node1);

        // ListNode node3 = new ListNode(2, node2);

        // ListNode node4 = new ListNode(1, node3);

        PalindromeLinkedList pt = new PalindromeLinkedList();

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1, node1);

        System.out.println(pt.isPalindrome(node2));

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

// /**
// * Definition for singly-linked list.
// * public class ListNode {
// * int val;
// * ListNode next;
// * ListNode() {}
// * ListNode(int val) { this.val = val; }
// * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// * }
// */
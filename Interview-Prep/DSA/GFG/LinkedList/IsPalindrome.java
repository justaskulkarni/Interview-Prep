package LinkedList;

public class IsPalindrome {
    boolean isPalindrome(Node head) {
        Node middle = middle(head);
        middle.next = reverse(middle.next);
        Node ptr1 = head;
        Node ptr2 = middle.next;
        while (ptr2 != null) {
            if (ptr1.data != ptr2.data)
                return false;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return true;
    }

    Node middle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    Node reverse(Node node) {
        Node prev = null;
        Node next = null;
        Node curr = node;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

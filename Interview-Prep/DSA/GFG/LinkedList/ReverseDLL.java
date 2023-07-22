package LinkedList;

public class ReverseDLL {
    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node reverseDLL(Node head) {
        Node prev = null;
        Node next = null;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.prev = next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

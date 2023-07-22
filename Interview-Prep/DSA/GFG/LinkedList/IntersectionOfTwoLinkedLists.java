package LinkedList;



public class IntersectionOfTwoLinkedLists {
    // TC: O(N + M)
    // SC: O(MAX(N, M))
    static class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
    public static Node findIntersection(Node head1, Node head2) {
        Node p1 = head1, p2 = head2;
        Node head = null, tail = null;

        while (p1 != null && p2 != null)
            if (p1.data > p2.data)
                p2 = p2.next;

            else if (p2.data > p1.data)
                p1 = p1.next;

            else {

                if (head == null)
                    head = tail = new Node(p1.data);
                else {
                    tail.next = new Node(p1.data);
                    tail = tail.next;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

        return head;
    }
    // Recursive Approach
    // TC: O(N + M)
    // SC: O(MAX(N, M))
    public static Node findIntersectionRecursion(Node head1, Node head2)
    {
        if(head1 == null || head2 == null)
            return null;
        if(head1.data < head2.data)
            return findIntersection(head1.next, head2);
        if(head1.data > head2.data)
            return findIntersection(head1, head2.next);
        Node temp = new Node(head1.data);
        temp.next = findIntersection(head1.next, head2.next);
        return temp;
    }
}

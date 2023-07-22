package LinkedList;

public class DeleteNodesWithGreaterValueToTheRight {
    // Bruteforce Approach
    // Using two for loops
    // TC: O(N^2)
    // SC: O(1)

    // Better Approach
    // TC: O(N)
    // SC: O(N)
    Node compute(Node head) {
        head = reverse(head);
        int maxUntilNow = head.data;
        Node curr = head;
        Node next = head.next;
        while (next != null) {
            if (next.data >= maxUntilNow) {
                maxUntilNow = next.data;
                curr = next;
                next = next.next;
            } else {
                next = next.next;
                curr.next = next;
            }
        }
        return reverse(head);
    }

    Node reverse(Node head) {
        Node prev = null;
        Node next = null;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Optimized Approach
    /*
     * The other simpler method is to traverse the list from the start and delete
     * the node when the current Node < next Node. To delete the current node,
     * follow this approach.
     * 
     * 
     * TC: O(N)
     * SC: O(1) 
     * 
     * Let us assume you have to delete current node X
     * 
     * 
     * 
     * 
     * 
     * 1. Copy next node's data into X i.e X.data = X.next.data
     * 
     * 
     * 
     * 
     * 
     * 2. Copy next node's next address i.e X.next = X.next.next;
     */
}

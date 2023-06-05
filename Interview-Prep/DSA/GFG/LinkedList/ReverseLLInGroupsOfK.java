package LinkedList;
/*
 * First attempt: Was not able to do the bruteforce approach
 */
public class ReverseLLInGroupsOfK {
    // Bruteforce Approach
    // TC: O(N) where N indicates number of nodes
    // SC: O(N/k) since N/k recusive calls are made each time
    
    public static Node reverse(Node node, int k) {
        int count = 0;
        Node curr = node;
        Node prev = null;
        Node next = null;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null)
            node.next = reverse(next, k);

        return prev;
    }
}

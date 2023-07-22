package LinkedList;
/*
 * First attempt: Was not able to do the bruteforce approach
 */

public class ReverseLLInGroupsOfK {
    // Bruteforce Approach
    // TC: O(N) where N indicates number of nodes
    // SC: O(N/k) since N/k recusive calls are made each time

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

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

    // Space Optimized Approach
    public static Node reverseSpaceOptimized(Node node, int k)
    {
        if(node == null || node.next == null)
            return node;
        Node dummy = new Node(-1);
        dummy.next = node;
        Node prev = dummy;
        Node curr = dummy;
        Node next = dummy;
        int count = 0;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        while(next != null){
            curr = prev.next;
            next = curr.next;
            int toLoop = count > k ? k : count - 1;
            for(int i = 1; i < toLoop; i++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }
        return dummy.next;
    }
}

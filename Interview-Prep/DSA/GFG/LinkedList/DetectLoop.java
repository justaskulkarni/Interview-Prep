package LinkedList;
import java.util.Set;
import java.util.HashSet;

/*
 * First Attempt: Logic Did not Strike
*/
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

/*
 * TC: O(N)
 * SC: O(N)
 */

public class DetectLoop {
    public static boolean detectLoop(Node head) {
        // Add code here
        Node curr = head;
        Set<Node> set = new HashSet<>();

        while (curr.next != null) {
            if (set.contains(curr))
                return true;
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }
}

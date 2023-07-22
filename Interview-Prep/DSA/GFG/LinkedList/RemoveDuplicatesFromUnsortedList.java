package LinkedList;
import java.util.Set;
import java.util.HashSet;

public class RemoveDuplicatesFromUnsortedList {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    public Node removeDuplicates(Node head) 
    {
        if(head.next == null)
            return head;
        Set<Integer> set = new HashSet<>();
        Node curr = head;
        while(curr.next != null){
            set.add(curr.data);
            if(set.contains(curr.next.data)){
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }
        return head;
    }
}

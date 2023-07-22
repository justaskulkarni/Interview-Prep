package LinkedList;

import java.util.HashSet;

public class DeleteLoop {
    public static void removeLoop(Node head){
        Node curr = head;
        Node prev = null;
        HashSet<Node> set = new HashSet<>();
        while(curr.next != null){
            if(set.contains(curr)){
                prev.next = null;
                return;
            }
            set.add(curr);
            prev = curr;
            curr = curr.next;
        }
    }   
}

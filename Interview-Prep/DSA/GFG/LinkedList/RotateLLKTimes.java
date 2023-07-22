package LinkedList;

public class RotateLLKTimes {
    public Node rotate(Node head, int k) {
        Node curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = head;
        curr = head;
        int count = 1;
        while(count != k){
            curr = curr.next;
            count++;
        }
        head = curr.next;
        curr.next = null;
        return head;
    }
}

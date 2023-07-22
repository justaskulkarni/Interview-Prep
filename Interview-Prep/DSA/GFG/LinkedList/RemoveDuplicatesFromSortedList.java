package LinkedList;

public class RemoveDuplicatesFromSortedList {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    Node removeDuplicates(Node head)
    {
	    Node curr = head;
	    while(curr.next != null){
	        if(curr.data == curr.next.data)
	            curr.next = curr.next.next;
	        else
	            curr = curr.next;
	    }
	    return head;
    }
}

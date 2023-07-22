package LinkedList;

public class NthNodeFromEnd {
    int getNthFromLast(Node head, int n)
    {
    	Node curr = head;
    	int count = 0;
    	
    	while(curr != null){
    	    curr = curr.next;
    	    ++count;
    	}
    	
        curr = head;
        
        if(n > count)
            return -1;
        
        while(count-- - n > 0){
            curr = curr.next;
        }
        
        return curr.data;
    }
    // In one pass
    int getNthFromLastOnePass(Node head, int n)
    {
    	Node curr = head;
    	int count = 0;
    	
    	while(curr != null){
    	    curr = curr.next;
    	    ++count;
    	}
    	
        if(n > count)
            return -1;
        
        curr = head;
        Node temp = head;
        
        while(--n > 0){
            curr = curr.next;
        }
        
        while(curr.next != null){
    	    curr = curr.next;
    	    temp = temp.next;
    	}
    	
    	return temp.data;
    }
}

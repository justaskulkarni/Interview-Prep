package LinkedList;

public class AddTwoNumbersLL {
    static Node addTwoLists(Node first, Node second){
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node ptr1 = reverse(first);
        Node ptr2 = reverse(second);
        int sum = 0;
        int carry = 0;
        while(ptr1 != null || ptr2 != null || carry != 0){
            sum = 0;
            if(ptr1 != null){
                sum += ptr1.data;
                ptr1 = ptr1.next;
            }
            if(ptr2 != null){
                sum += ptr2.data;
                ptr2 = ptr2.next;
            }
            sum += carry;
            carry = sum / 10;
            Node new_node = new Node(sum % 10);
            temp.next = new_node;
            temp = temp.next;

        }
        return reverse(dummy.next);
    }
    static Node reverse(Node head){
        Node prev = null;
        Node next = null;
        Node curr = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

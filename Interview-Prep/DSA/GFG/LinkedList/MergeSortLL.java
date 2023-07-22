package LinkedList;

public class MergeSortLL {
    // TC: O(NlogN)
    // SC: O(N)
    static Node mergeSort(Node head)
    {
        if(head == null || head.next == null)
            return head;
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);
        return merge(left, right);
    }
    static Node getMiddle(Node head){
        if(head == null)
            return head;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    static Node merge(Node head1, Node head2){
        Node result = null;
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        if(head1.data <= head2.data){
            result = head1;
            result.next = merge(head1.next, head2);
        }
        else{
            result = head2;
            result.next = merge(head1, head2.next);
        }
        return result;
    }
    // SC: O(logN)
    static Node mergeSpaceOptimised(Node head1, Node head2){
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}

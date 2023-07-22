package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeKSortedLL {
    // Bruteforce Approach
    /*
     * A Simple Solution is to initialize the result as the first list.
     * Now traverse all lists starting from the second list.
     * Insert every node of the currently traversed list into the result in a sorted
     * way.
     * Time complexity: O(N^(K-1)), Traversing N times on each of the K lists.
     * Auxiliary Space: O(1).
     */
    // Better Bruteforce Approach
    /*
     * Find the node with the smallest value in all the K lists and
     * Increment the current pointer to the next node of the list where the smallest
     * node is found.
     * Now make a new node and append the node to the head node of the resultant
     * list and point the head list with this new node
     * Repeat these steps till all nodes have been used
     * Time complexity: O(N*K2), There are N*K nodes in total and to find the
     * smallest node it takes K times so for the N*K nodes it will take N*K*K time.
     * Auxiliary Space: O(N)
     */
    // Min Heap Approach
    /*
     * Time Complexity: O(N * K * log K)
     * Auxiliary Space: O(K)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int k = lists.length;
        for (int i = 0; i < k; i++)
            if (lists[i] != null)
                pq.add(lists[i]);
        if (pq.isEmpty())
            return null;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;
            if (node.next != null)
                pq.add(node.next);
        }
        return dummy.next;
    }
    // Divide and Conquer
    public ListNode mergeKListsDnC(ListNode[] lists) {
        int last = lists.length - 1;
        while (last != 0) {
            int i = 0, j = last;
  
            // (i, j) forms a pair
            while (i < j) {
                // merge List i with List j and store
                // merged list in List i
                lists[i] = SortedMerge(lists[i], lists[j]);
  
                // consider next pair
                i++;
                j--;
  
                // If all pairs are merged, update last
                if (i >= j)
                    last = j;
            }
        }
        return lists[0];
    }
    public static ListNode SortedMerge(ListNode a, ListNode b)
    {
        ListNode result = null;
        /* Base cases */
        if (a == null)
            return b;
        else if (b == null)
            return a;
  
        /* Pick either a or b, and recur */
        if (a.val <= b.val) {
            result = a;
            result.next = SortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = SortedMerge(a, b.next);
        }
  
        return result;
    }
}

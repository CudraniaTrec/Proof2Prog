//swapping-nodes-in-a-linked-list
import java.util.List;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int x) {
          val = x;
          next = null;
      }
      ListNode(int val, ListNode next) { 
        this.val = val; this.next = next; 
      }
    }
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int listLength = 0;
        ListNode frontNode = null;
        ListNode endNode = null;
        ListNode currentNode = head;
        // find the length of list and set the front node
        while (currentNode != null) {
            listLength++;
            if (listLength == k) {
                frontNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        // set the end node at (listLength - k)th node
        endNode = head;
        for (int i = 1; i <= listLength - k; i++) {
            endNode = endNode.next;
        }
        // swap front node and end node values
        int temp = frontNode.val;
        frontNode.val = endNode.val;
        endNode.val = temp;
        return head;
    }
}
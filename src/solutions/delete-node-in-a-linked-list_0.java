//delete-node-in-a-linked-list
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
    public void deleteNode(ListNode node) {
        // Since we know input node is not last node, so nextNode will not be null
        ListNode nextNode = node.next;
        // Step 2
        node.val = nextNode.val;
        // Step 3
        node.next = nextNode.next;
        nextNode.next = null;
    }
}
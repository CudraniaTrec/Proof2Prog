//linked-list-cycle-ii
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
    public ListNode detectCycle(ListNode head) {
        // Initialize tortoise and hare pointers
        ListNode tortoise = head;
        ListNode hare = head;

        // Move tortoise one step and hare two steps
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            // Check if the hare meets the tortoise
            if (tortoise == hare) {
                break;
            }
        }

        // Check if there is no cycle
        if (hare == null || hare.next == null) {
            return null;
        }

        // Reset either tortoise or hare pointer to the head
        hare = head;

        // Move both pointers one step until they meet again
        while (tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
        }

        // Return the node where the cycle begins
        return tortoise;
    }
}
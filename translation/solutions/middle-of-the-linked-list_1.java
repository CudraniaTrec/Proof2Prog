//middle-of-the-linked-list
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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
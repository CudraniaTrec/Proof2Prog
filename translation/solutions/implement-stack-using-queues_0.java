//implement-stack-using-queues
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
class Solution {
private Queue<Integer> q1 = new LinkedList<>();
private Queue<Integer> q2 = new LinkedList<>();
private int top;

// Push element x onto stack.
public void push(int x) {
    q1.add(x);
    top = x;
}
}
package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class InsertGcd {
    private ListNode head;
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.next = null;
            this.val = val;
        }
    }

    void push(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode f = head;
        ListNode s = head.next;
        List<Integer> g = new ArrayList<>();
        while (s!=null){
            g.add(gcd(s.val,f.val));
            f = f.next;
            s = s.next;
        }

        f = head;
        s = head.next;
        int index = 0;

        while (s != null && index < g.size()) {
            ListNode newNode = new ListNode(g.get(index));
            f.next = newNode;
            newNode.next = s;
            f = s;
            s = s.next;
            index++;
        }
        return head;
    }
    public static void main(String[] args) {

    }
}

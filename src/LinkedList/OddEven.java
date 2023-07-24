package LinkedList;

import java.util.Scanner;

public class OddEven {
    private ListNode head;

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
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
    public void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("null");
    }
    public ListNode oddeven(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddHead = odd;
        ListNode evenHead = even;
        while (odd != null && odd.next != null && even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return oddHead;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OddEven list = new OddEven();
        for (int i = 0; i < 7; i++) {
            list.push(sc.nextInt());
        }
        list.display(list.oddeven(list.head));
    }
}

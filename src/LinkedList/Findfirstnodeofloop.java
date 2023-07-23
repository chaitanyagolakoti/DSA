package LinkedList;

import java.util.Scanner;

public class Findfirstnodeofloop {
    private ListNode head;
    private static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
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

    public ListNode find(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        boolean hasLoop = false;
        while(fast.next!=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                hasLoop = true;
                break;
            }
        }
        if(!hasLoop){
            return null;
        }
        if(hasLoop){
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Create the first linked list
        Findfirstnodeofloop list = new Findfirstnodeofloop();
        int n1 = sc.nextInt();
        for (int i = 0; i < n1; i++) {
            list.push(sc.nextInt());
        }
        ListNode loop = list.head.next.next.next;
        loop.next = list.head.next;
        list.head = list.find(list.head);
        list.display(list.head);

    }
}

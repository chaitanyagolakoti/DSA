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
//        System.out.println(fast.val);
        return slow;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Create the first linked list
        Findfirstnodeofloop list = new Findfirstnodeofloop();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        // Build the linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

        // Create a loop in the linked list by connecting the last node to the second node
        sixth.next = second;
        ListNode startOfLoop = list.find(head);
        if (startOfLoop != null) {
            System.out.println("Starting node of the loop: " + startOfLoop.val);
        } else {
            System.out.println("No loop found in the linked list.");
        }
    }
}

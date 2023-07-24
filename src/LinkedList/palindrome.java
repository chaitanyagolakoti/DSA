package LinkedList;

import java.util.Scanner;

public class palindrome {
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
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;  // Store reference to the next node
            head.next = newHead;  // Reverse the link of current node to the previous node
            newHead = head;  // Set the current node as the new head
            head = next;  // Move to the next node
        }
        head = newHead;
        return head;
    }
    public boolean palin(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        if (fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = reverseList(slow);
        ListNode secondhead = secondHalf;

        // Compare the first and second halves for palindrome check
        while (secondHalf != null && head!=null) {
            if (head.val != secondHalf.val) {
                return false;
            }
            head = head.next;
            secondHalf = secondHalf.next;
        }
        reverseList(secondhead);
        return (head == null || secondHalf == null);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Create the first linked list
        palindrome list = new palindrome();
//        int n1 = sc.nextInt();
//        for (int i = 0; i < n1; i++) {
//            list.push(sc.nextInt());
//        }
        ListNode unsortedList = new ListNode(1);
        unsortedList.next = new ListNode(0);
        unsortedList.next.next = new ListNode(3);
        unsortedList.next.next.next = new ListNode(4);
        unsortedList.next.next.next.next = new ListNode(0);
        unsortedList.next.next.next.next.next = new ListNode(1);
        System.out.println(list.palin(unsortedList));
    }
}

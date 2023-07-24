package LinkedList;

import java.util.Scanner;

public class ReverseList2 {
    private ListNode head;

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right){
        if(left == right){
            return head;
        }
        else if(head==null){
            return null;
        }
        ListNode curr = head;
        ListNode prev = null;
        for(int i=1;i<left;i++){
            prev = curr;
            curr = curr.next;
        }
        ListNode firstEnd = prev;
        ListNode SecondEnd = curr;
        ListNode newNode = curr.next;
        for (int i = 0; i < right-left+1; i++) {
            curr.next = prev;
            prev = curr;
            curr = newNode;
            if (newNode!=null){
                newNode = newNode.next;
            }
        }
        if (firstEnd!=null){
            firstEnd = prev;
        }else {
            head = prev;
        }
        SecondEnd.next = curr;
        return head;
    }
    public ListNode mergeInBetween(ListNode head, int m, int n) {
        // Check for edge cases
        if (head == null || m == n) {
            return head;
        }

        // Initialize pointers to keep track of the nodes we need to modify
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 1; i < m; i++) {
            prev = curr;
            curr = curr.next;
        }

        // Split the linked list into three parts
        ListNode firstPartEnd = prev;
        ListNode secondPartStart = curr;
        for (int i = m; i <= n; i++) {
            prev = curr;
            curr = curr.next;
        }
        ListNode secondPartEnd = prev;
        ListNode thirdPartStart = curr;

        // Reverse the second part of the linked list
        prev = null;
        curr = secondPartStart;
        while (curr != thirdPartStart) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        // Connect the three parts of the linked list
        if (firstPartEnd != null) {
            firstPartEnd.next = secondPartEnd;
        } else {
            head = secondPartEnd;
        }
        secondPartStart.next = thirdPartStart;

        return head;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create the first linked list
        ReverseList2 merge1 = new ReverseList2();
        System.out.println("Enter the number of elements for the first linked list:");
        int n1 = sc.nextInt();
        System.out.println("Enter the elements for the first linked list:");
        for (int i = 0; i < n1; i++) {
            merge1.push(sc.nextInt());
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        merge1.head = merge1.mergeInBetween(merge1.head, a, b);
        merge1.display(merge1.head);
    }
}

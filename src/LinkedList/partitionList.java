package LinkedList;

import java.util.Scanner;

public class partitionList {
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
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = null;
        ListNode smallerTail = null;
        ListNode largerHead = null;
        ListNode largerTail = null;
        ListNode current = head;

        while (current != null) {
            ListNode newNode = new ListNode(current.val);
            if (current.val < x) {
                if (smallerHead == null) {
                    smallerHead = newNode;
                    smallerTail = newNode;
                } else {
                    smallerTail.next = newNode;
                    smallerTail = smallerTail.next;
                }
            } else {
                if (largerHead == null) {
                    largerHead = newNode;
                    largerTail = newNode;
                } else {
                    largerTail.next = newNode;
                    largerTail = largerTail.next;
                }
            }
            current = current.next;
        }

        if (smallerHead == null) {
            return largerHead;
        } else {
            smallerTail.next = largerHead;
            return smallerHead;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Create the first linked list
        partitionList merge1 = new partitionList();

        int n1 = sc.nextInt();

        for (int i = 0; i < n1; i++) {
            merge1.push(sc.nextInt());
        }
        int x = sc.nextInt();
        merge1.head = merge1.partition(merge1.head,x);
        merge1.display(merge1.head);
    }
}

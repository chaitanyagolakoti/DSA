package LinkedList;

import java.util.Scanner;

public class MergeInBetween {
    private ListNode head;
    private static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tempa = list1;
        ListNode preva = null;
        int counta = 0;
        while (tempa != null) {
            if (counta == a) {
                break;
            }
            preva = tempa;
            tempa = tempa.next;
            counta++;
        }
        ListNode tempb = tempa;
        int countb = 0;
        while (tempb != null) {
            if (countb == b-a) {
                break;
            }
            tempb = tempb.next;
            countb++;
        }
        // Connect the node at position 'a' to the head of 'list2'
        if (preva != null) {
            preva.next = list2;
        } else {
            list1 = list2; // If 'a' is 0, update the head of 'list1'
        }
        // Find the tail of 'list2'
        ListNode tailList2 = list2;
        while (tailList2.next != null) {
            tailList2 = tailList2.next;
        }
        // Connect the tail of 'list2' to the node at position 'b'
        tailList2.next = tempb.next;
        System.gc();
        return list1;
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
        MergeInBetween merge1 = new MergeInBetween();
        System.out.println("Enter the number of elements for the first linked list:");
        int n1 = sc.nextInt();
        System.out.println("Enter the elements for the first linked list:");
        for (int i = 0; i < n1; i++) {
            merge1.push(sc.nextInt());
        }

        // Create the second linked list
        MergeInBetween merge2 = new MergeInBetween();
        System.out.println("Enter the number of elements for the second linked list:");
        int n2 = sc.nextInt();
        System.out.println("Enter the elements for the second linked list:");
        for (int i = 0; i < n2; i++) {
            merge2.push(sc.nextInt());
        }

        // Display the two original lists
        System.out.println("First Linked List:");
        merge1.display(merge1.head);
        System.out.println("Second Linked List:");
        merge2.display(merge2.head);

        // Merge the two lists
        System.out.println("Enter the value of 'a' and 'b' for merging:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        merge1.head = merge1.mergeInBetween(merge1.head, a, b, merge2.head);

        // Display the merged list
        System.out.println("Merged Linked List:");
        merge1.display(merge1.head);

        sc.close();
    }
}

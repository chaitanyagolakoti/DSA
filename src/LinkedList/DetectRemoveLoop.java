package LinkedList;

import java.util.Scanner;

public class DetectRemoveLoop {
    private ListNode head;
    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(int val, ListNode next) {
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
    public ListNode removeLoop(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            ListNode prv = slow;
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = head;
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                if (slow == head && fast == head){
                    prv.next = null;
                }
                else {
                    slow.next = null;
                }
                return head;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Create the first linked list
        DetectRemoveLoop list = new DetectRemoveLoop();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seventh = new ListNode(7);

        // Build the linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

        // Create a loop in the linked list by connecting the last node to the second node
        sixth.next = seventh;
        sixth.next = third;
        list.display(list.removeLoop(head));
    }
}

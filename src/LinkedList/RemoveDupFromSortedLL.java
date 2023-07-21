package LinkedList;

import java.util.Scanner;

public class RemoveDupFromSortedLL {
    private static Node head;
    private static class Node{
        private int val;
        private Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    public RemoveDupFromSortedLL(){
        this.head = null;
    }
    static void display(){
        Node curr = head;
        while ((curr!=null)){
            System.out.print(curr.val+"->");
            curr = curr.next;
        }
        System.out.println("null");
    }
    static void push(int val){
        Node newNode = new Node(val);
        if(head==null){
            head = newNode;
        }
        else{
            Node cur = head;
            while (cur.next!= null){
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }
    static void removeDuplicates() {
        if (head == null || head.next == null) {
            // If the list is empty or has only one node, no duplicates to remove
            return;
        }
        Node current = head;
        while (current != null) {
            // Check if there are duplicates from the current node onwards
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    // Duplicate found, remove the duplicate node
                    runner.next = runner.next.next;
                } else {
                    // Move the runner pointer to the next node
                    runner = runner.next;
                }
            }
            // Move the current pointer to the next unique node
            current = current.next;
        }
    }
    static void RemoveDups(){
        Node current = head;
        while (current.next!=null){
            if(current.val == current.next.val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            push(sc.nextInt());
        }
        RemoveDups();
        display();
    }
}

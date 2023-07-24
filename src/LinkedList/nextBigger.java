package LinkedList;

import java.util.Scanner;
import java.util.Arrays;
public class nextBigger {
    private ListNode head;
    private static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    void push(int val){
        ListNode newNode = new ListNode(val);
        if (head==null){
            head = newNode;
        }
        else{
            ListNode curr = head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }
    void display(){
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("null");
    }
    static int length(ListNode head){
        ListNode temp=head;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
    public int[] nextLargerNodes(ListNode head) {
        int size = length(head);
        int arr[] = new int[size];
        ListNode start = head;
        for (int i = 0; i < size; i++) {
            ListNode curr = start.next;
            while (curr != null) {
                if (curr.val > start.val) {
                    arr[i] = curr.val;
                    break;
                }
                curr = curr.next;
            }
            start = start.next;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nextBigger list = new nextBigger();
        int n = sc.nextInt();
        // Input the elements for the linked list
        for (int i = 0; i < n; i++) {
            list.push(sc.nextInt());
        }
        int[] result = list.nextLargerNodes(list.head);
        System.out.println(Arrays.toString(result));
    }
}

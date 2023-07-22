package LinkedList;

public class MergerSort {
    private ListNode head;
    private static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
        public ListNode(){

        }
    }
    public ListNode middleNode(ListNode head) {
//        ListNode fast=head;
//        ListNode slow=head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
        ListNode midP = null;
        while(head !=null && head.next!=null){
            midP = (midP == null)? head : midP.next;
            head = head.next;
        }
        ListNode mid = midP.next;
        midP.next = null;
        return mid;
    }
    public ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(); // Dummy node to simplify code
        ListNode current = dummy;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                current.next = first;
                first = first.next;
                current = current.next;
            } else {
                current.next = second;
                second = second.next;
                current = current.next;
            }
        }
        // If one list becomes empty, attach the remaining list to the merged list
        if (first != null) {
            current.next = first;
        } else {
            current.next = second;
        }
        return dummy.next;
    }
    public ListNode sortList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left,right);
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
        MergerSort merger = new MergerSort();

        // Create the unsorted linked list: 4 -> 2 -> 1 -> 3 -> 5
        ListNode unsortedList = new ListNode(4);
        unsortedList.next = new ListNode(2);
        unsortedList.next.next = new ListNode(1);
        unsortedList.next.next.next = new ListNode(3);
        unsortedList.next.next.next.next = new ListNode(5);

        System.out.println("Unsorted list:");
        merger.display(unsortedList);

        ListNode sortedList = merger.sortList(unsortedList);

        System.out.println("Sorted list:");
        merger.display(sortedList);
    }
}

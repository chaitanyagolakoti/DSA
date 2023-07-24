package LinkedList;

public class RemoveNthNodeEnd {
    private ListNode head;

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
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
    public void deleteAtposition(ListNode head, int pos) {
        if (head == null) {
            return; // Empty list, nothing to delete
        }
        if (pos == 1) {
            head = head.next; // Delete the first node (head)
            return;
        }
        int count = 1;
        ListNode currentNode = head;
        ListNode prev = null;
        while (currentNode != null) {
            if (count == pos) {
                prev.next = currentNode.next; // Delete the node at the specified position
                return;
            }
            count++;
            prev = currentNode;
            currentNode = currentNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        deleteAtposition(dummy, length - n+2);
        return dummy.next;
    }
    public static void main(String[] args) {
        RemoveNthNodeEnd list = new RemoveNthNodeEnd();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);list.push(5);
        list.display(list.removeNthFromEnd(list.head,2));

    }
}

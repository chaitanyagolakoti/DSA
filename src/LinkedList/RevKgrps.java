package LinkedList;

public class RevKgrps {
    private ListNode head;

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
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
    public ListNode revKgrps(ListNode head, int k){
        if(head == null || k<=1){
            return head;
        }
        int size = 0;
        int len = length(head);
        ListNode curr=head;
        ListNode prev=null;
        while (curr != null){
            ListNode firstEnd = prev;
            ListNode SecondEnd = curr;
            ListNode newNode = curr.next;
            for (int i = 0; i < k; i++) {
                size++;
                curr.next = prev;
                prev = curr;
                curr = newNode;
                if (newNode!=null){
                    newNode = newNode.next;
                }
            }
            if (firstEnd!=null){
                firstEnd.next = prev;
            }else {
                head = prev;
            }
            SecondEnd.next = curr;
            if (len - size<k){
                break;
            }
            prev = SecondEnd;
        }
        return head;
    }
    public ListNode reverseKGroupRec(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        int count = 0;
        ListNode newHead = head;
        while (newHead != null && count < k) {
            newHead = newHead.next;
            count++;
        }
        if (count == k) { //only the groups of size k will be reversed remaining are left alone
            ListNode curr = reverseKGroupRec(newHead, k); // Recursively reverse the remaining part
            // Reverse the current group
            while (count > 0) {
                ListNode nextNode = head.next;
                head.next = curr;
                curr = head;
                head = nextNode;
                count--;
            }
            head = curr;
        }
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
        RevKgrps list = new RevKgrps();
        ListNode start = new ListNode(1);
        start.next = new ListNode(2);
        start.next.next= new ListNode(3);
        start.next.next.next = new ListNode(4);
        start.next.next.next.next = new ListNode(5);
        list.display(list.reverseKGroupRec(start,3));

    }
}

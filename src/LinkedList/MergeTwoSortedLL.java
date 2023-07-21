package LinkedList;
public class MergeTwoSortedLL {
    private Node head;
    private static class Node {
        private int val;
        private Node next;
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public MergeTwoSortedLL() {
        this.head = null;
    }

    void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    void push(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }
    static MergeTwoSortedLL merge(MergeTwoSortedLL first, MergeTwoSortedLL second) {
        Node l1 = first.head;
        Node l2 = second.head;
        MergeTwoSortedLL ans = new MergeTwoSortedLL();
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ans.push(l1.val);
                l1 = l1.next;
            } else {
                ans.push(l2.val);
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            ans.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            ans.push(l2.val);
            l2 = l2.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        MergeTwoSortedLL firstList = new MergeTwoSortedLL();
        firstList.push(1);
        firstList.push(3);
        firstList.push(5);
        firstList.push(11);

        MergeTwoSortedLL secondList = new MergeTwoSortedLL();
        secondList.push(1);
        secondList.push(2);
        secondList.push(4);
        secondList.push(13);
        secondList.push(19);

        MergeTwoSortedLL mergedList = MergeTwoSortedLL.merge(firstList, secondList);
        mergedList.display();
    }
}

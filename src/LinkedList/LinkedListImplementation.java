package LinkedList;
public class LinkedListImplementation {
    private static Node head;
    private int size;

    public LinkedListImplementation() {
        this.size = 0;
    }

    private class Node {
        private Node next;
        private int val;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public void display() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val + "->");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }
    public void insertAtfirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size += 1;
    }

    public void insertAtend(int val) {
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
    public void deleteFirst(){
        if(head==null || head.next==null){
            head = null;
        }
        int first = head.val;
        head = head.next;
        size = size-1;
//        System.out.println(first);
    }
    public void deleteEnd(){
        if(head==null || head.next==null){
            head = null;
        }
        else {
            Node currentNode = head;
            Node prev = null; // Initialize prev to null
            while (currentNode.next != null) {
                prev = currentNode;
                currentNode = currentNode.next;
            }
//            int last = currentNode.val;
//            System.out.println(last);
            prev.next = null; // Set the next pointer of the second-to-last node to null
        }
    }
    public void deleteAtposition(int pos) {
        if (head == null) {
            return; // Empty list, nothing to delete
        }
        if (pos == 0) {
            head = head.next; // Deleting the first node, update head
            return;
        }
        int count = 1;
        Node currentNode = head;
        Node prev = null;
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
    public void insertAtpos(int ind, int val){
        Node newNode = new Node(val);
        if (head == null && ind>0) {
            return; // Empty list, nothing to delete
        }
        else if(ind==0){
            newNode.next = head;
            head = newNode;
            return;
        }
        else if(ind > 0){
            int count = 0;
            Node currentNode = head;
            Node prev = null;
            while (currentNode != null) {
                if (count == ind) {
                    prev.next = newNode;
                    newNode.next = currentNode; // Delete the node at the specified position
                    return;
                }
                count++;
                prev = currentNode;
                currentNode = currentNode.next;
            }
        }
    }
    public void insertAtposRec(int ind, int val) {
        head = insertAtposRecHelper(ind, val, head);
    }
    private Node insertAtposRecHelper(int ind, int val, Node node) {
        if(ind==0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertAtposRecHelper(ind-1,val,node.next);
        return node;
    }
}
    class Main{
    public static void main(String[] args) {
        LinkedListImplementation LL = new LinkedListImplementation();
//        for (int i = 0; i < 7; i++) {
////            LL.insertAtfirst(i);
//            LL.insertAtend(i);
//        }
        LL.insertAtend(2);
        LL.insertAtend(6);
        LL.insertAtend(7);
        LL.insertAtend(19);
        LL.insertAtend(220);
        LL.insertAtend(8);
        LL.insertAtend(9);
//        LL.deleteFirst();
//        LL.deleteEnd();
//        LL.deleteAtposition(2);
        LL.insertAtposRec(3,33);
        LL.display();
    }
}

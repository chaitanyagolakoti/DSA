package LinkedList;
public class DoublyLLImplementation {
    private static Node head;
    private class Node {
        private Node next;
        private Node prev;
        private int val;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next,Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
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
    public void insertFirst(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        newNode.prev = null;
        if(head!=null){
            head.prev = newNode;
        }
        head = newNode;
    }
    public void insertEnd(int val){
        Node newNode = new Node(val);
        if(head==null){
            head = newNode;
        }
        else{
            Node currentNode = head;
            while (currentNode.next!= null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.prev = currentNode;
            newNode.next = null;
        }
    }
    public void DeleteFirst(){
        if(head==null){
            return;
        }
        else{
            head = head.next;
        }
    }
    public void DeleteEnd(){
        if(head==null || head.next==null){
            head = null;
        }
        else {
            Node currentNode = head;
            Node previous = null; // Initialize prev to null
            while (currentNode.next != null) {
//                previous = currentNode;
                currentNode = currentNode.next;
            }
            previous = currentNode.prev;
            previous.next = null; // Set the next pointer of the second-to-last node to null
//            currentNode.prev = null;
        }
    }
    public void DeletePosition(int pos){
        if (head == null) {
            return; // Empty list, nothing to delete
        }
        if (pos == 0) {
            head = head.next; // Deleting the first node, update head
            return;
        }
        int count = 1;
        Node currentNode = head;
        Node previ = null;
        while (currentNode != null) {
            if (count == pos) {
                previ.next = currentNode.next; // Delete the node at the specified position
                return;
            }
            count++;
            previ = currentNode;
            currentNode = currentNode.next;
        }
    }
}
class MainDLL{
    public static void main(String[] args) {
        DoublyLLImplementation Dll = new DoublyLLImplementation();
        for (int i = 0; i < 7; i++) {
//            Dll.insertFirst(i);
            Dll.insertEnd(i);
        }
//        Dll.DeleteFirst();
//        Dll.DeleteEnd();
        Dll.DeletePosition(2);
        Dll.display();
    }
}

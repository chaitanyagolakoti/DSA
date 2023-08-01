package Trees;

import java.util.Scanner;

public class Implementation {
    private Node root;
    private class Node{
         int val;Node left; Node right;
         public Node(int val){
             this.val = val;
             this.left = null;
             this.right = null;
         }
    }
    public void insert(Scanner sc){
        System.out.println("Enter the root");
        int value = sc.nextInt();
        Node root = new Node(value);
        insert(sc, root);
    }
    private void insert(Scanner sc , Node node){
        System.out.println("Want to enter left of node:" + node.val);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter value:");
            int value = sc.nextInt();
            node.left = new Node(value);
            insert(sc,node.left);
        }
        System.out.println("Want to enter right of node:" + node.val);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter value:");
            int value = sc.nextInt();
            node.right = new Node(value);
            insert(sc,node.right);
        }
    }
    public void display() {
        display(this.root, "");
    }
    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.val);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Implementation binaryTree = new Implementation();
        binaryTree.insert(sc);
        System.out.println("Binary Tree:");
        binaryTree.display();
        sc.close();
    }
}

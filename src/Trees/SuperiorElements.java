package Trees;

import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode root, int value) {
        if (root == null) {
            return root = new TreeNode(value);
        }

        if (value <= root.value) {
            root.left = insertRecursive(root.left, value);
        } else if (value > root.value) {
            root.right = insertRecursive(root.right, value);
        }
        return root;
    }

    public void inOrderTraversal() {
        inOrderTraversalRecursive(root);
        System.out.println();
    }

    private void inOrderTraversalRecursive(TreeNode root) {
        if (root != null) {
            inOrderTraversalRecursive(root.left);
            System.out.print(root.value + " ");
            inOrderTraversalRecursive(root.right);
        }
    }
}
public class SuperiorElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        BinarySearchTree bst = new BinarySearchTree();
        for (int value : arr) {
            bst.insert(value);
        }

        System.out.print("In-order traversal of the binary search tree: ");
        bst.inOrderTraversal();

        scanner.close();
    }
}

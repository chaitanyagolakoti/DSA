package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Spiral {
    public static void spiral(int[][] matrix, int i, int j, int direction, List<Integer> ds) {
        int n = matrix.length;
        int m = matrix[0].length;
        // Base case: check if the current position is out of bounds or the element is already visited
        if (i < 0 || j < 0 || i >= n || j >= m || matrix[i][j] == -1) {
            return;
        }
        // Add the current element to the list
        ds.add(matrix[i][j]);

        // Mark the current element as visited
        matrix[i][j] = -1;

        // Check the current direction and update i, j accordingly
        if (direction == 0) { // Move right
            if (j + 1 < m && matrix[i][j + 1] != -1) {
                spiral(matrix, i, j + 1, direction, ds); // Move right
            } else {
                spiral(matrix, i + 1, j, (direction + 1) % 4, ds); // Change direction to move down
            }
        } else if (direction == 1) { // Move down
            if (i + 1 < n && matrix[i + 1][j] != -1) {
                spiral(matrix, i + 1, j, direction, ds); // Move down
            } else {
                spiral(matrix, i, j - 1, (direction + 1) % 4, ds); // Change direction to move left
            }
        } else if (direction == 2) { // Move left
            if (j - 1 >= 0 && matrix[i][j - 1] != -1) {
                spiral(matrix, i, j - 1, direction, ds); // Move left
            } else {
                spiral(matrix, i - 1, j, (direction + 1) % 4, ds); // Change direction to move up
            }
        } else if (direction == 3) { // Move up
            if (i - 1 >= 0 && matrix[i - 1][j] != -1) {
                spiral(matrix, i - 1, j, direction, ds); // Move up
            } else {
                spiral(matrix, i, j + 1, (direction + 1) % 4, ds); // Change direction to move right
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        List<Integer> ds = new ArrayList<>();
        spiral(matrix, 0, 0,0, ds);
        // Print the elements in the clockwise spiral order
        for (Integer num : ds) {
            System.out.print(num + " ");
        }
    }
}

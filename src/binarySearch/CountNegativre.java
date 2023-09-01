package binarySearch;

public class CountNegativre {
    public static int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count=0;
        for(int i=0;i<row;i++){
            int left = 0;
            int right = col - 1;

            while (left<=right){
                int mid = left + (right - left)/2;
                if(grid[i][mid]<0){
                    right = mid-1;
                }
                else {
                    left = mid+1;
                }
            }
            count += col - left;
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {-3, -2, -1,  1},
                {-2,  2,  3,  4},
                { 4,  5,  7,  8}
        };
        int negativeCount = countNegatives(grid);
        System.out.println("Number of negative numbers: " + negativeCount);
    }
}

package Arrays;

public class ConsecutiveOnes {
    static int consecutive(int arr[], int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                int start = i;
                int j = start;
                while (j < n && arr[j] == 1) {
                    j++;
                }
                max = Math.max(max, (j - start));
                i = j - 1;  // Skip over the counted sequence
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,1,0,1,1};
        System.out.println(consecutive(arr, arr.length));
    }
}

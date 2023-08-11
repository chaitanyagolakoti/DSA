package Arrays;

import java.util.Arrays;

public class RearrangeArrayElementsbySign {
    static int[] rearrange(int arr[]) {
        int n = arr.length;
        int temp[] = new int[n];
        int j = 0;

        // Traverse the input array and copy positive numbers to even indices
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && j < n) {
                temp[j] = arr[i];
                j = j + 2;
            }
        }

        // Reset j and fill negative numbers at odd indices
        j = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0 && j < n) {
                temp[j] = arr[i];
                j = j + 2;
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        int arr[] = {1, -1, 3, 2, -7, -5, 11, 6 };
        System.out.println(Arrays.toString(rearrange(arr)));
    }
}

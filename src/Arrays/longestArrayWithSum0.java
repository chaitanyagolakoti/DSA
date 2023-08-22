package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class longestArrayWithSum0 {
    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        // Create a HashMap to store cumulative sums and their corresponding indices
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0; // Initialize the cumulative sum
        int len = 0; // Initialize the length of the longest subset with zero sum

        // Iterate through the ArrayList
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i); // Update the cumulative sum

            if (sum == 0) {
                len = i + 1; // If cumulative sum is zero, update the subset length
            } else if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum)); // Update subset length if zero-sum subarray found
            }

            // Store the cumulative sum and its index in the map
            else {
                map.put(sum, i);
            }
        }
        System.out.println(map);
        return len; // Return the length of the longest subset with zero sum
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 4, -7, 3, 1, 3, 1, -4, -2, -2));
        int longestSubsetLength = LongestSubsetWithZeroSum(arr);
        System.out.println("Length of longest subset with zero sum: " + longestSubsetLength);
    }
}

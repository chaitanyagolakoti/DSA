package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumk {
    public static int longestSubarrayWithSumK(int []arr, long k) {
        int n = arr.length;
        Map<Long, Integer> prefixSumIndex = new HashMap<>();
        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLen = Math.max(maxLen,i + 1); // Subarray from index 0 to i has sum k.
            }

            // Check if there's a prefix sum that, when removed from the current sum, results in k.
            if (prefixSumIndex.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - prefixSumIndex.get(sum - k));
            }

            // Store the current prefix sum and its index in the map.
            if (!prefixSumIndex.containsKey(sum)) {
                prefixSumIndex.put(sum, i);
            }
        }

        return maxLen;
    }
    public static void main(String[] args) {

    }
}

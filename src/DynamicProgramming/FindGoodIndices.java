package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class FindGoodIndices {
    public static List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();

        for (int i = k; i < nums.length - k; i++) {
            if (isValid(nums, k, i)) {
                ans.add(i);
            }
        }
        return ans;
    }
    public static boolean isValid(int[] nums, int k, int idx){
        boolean before  = true;
        boolean after = true;

        for (int i = idx - k + 1; i < idx ; i++) {
            if(nums[i] > nums[i - 1]) {
                before = false;
                break;
            }
        }

        for (int i = idx + 1; i - k < idx; i++) {
            if (nums[i] > nums[i + 1]){
                after = false;
                break;
            }
        }

        return before && after;
    }
    // TC: O(n * (n + n)) => O(n ^ 2)
    // SC: O(1) - ignoring the output array
    public static List<Integer> goodIndicesDp(int[] nums, int k) {
        int n = nums.length;

        int[] p = new int[n];       // prefix array
        int[] s = new int[n];       // suffix array

        p[0] = s[n - 1] = 1;

        // precomputing for the left
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                p[i] = p[i - 1] + 1;
            }
            else p[i] = 1;
        }

        // precomputing for the right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                s[i] = s[i + 1] + 1;
            }
            else s[i] = 1;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = k; i < n - k; i++) {
            if (p[i - 1] >= k && s[i + 1] >= k) {
                ans.add(i);
            }
        }

        return ans;
    }
    // TC: O(n) + O(n) + O(n) => O(n)
    // SC: O(n) + O(n) => O(n) - Ignoring the output array
    public static void main(String[] args) {
        int arr[] = {2,1,1,1,3,4,1};
        int k = 2;
        System.out.println(goodIndicesDp(arr,k));
    }
}


package Arrays;

import java.util.HashSet;

public class LongestCommonSequence {
    public static int longestConsecutive(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        int first =0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(!set.contains(arr[i]-1)){
                first = arr[i];
                int length = 1;
                while (set.contains(first + 1)) {
                    first++;
                    length++;
                }
                count = Math.max(count, length);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(arr));
    }
}

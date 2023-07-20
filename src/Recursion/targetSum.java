package Recursion;
public class targetSum {
    private static int findCombinations(int ind, int[] arr, int target) {
        if (ind == arr.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int result = 0;
        result += findCombinations(ind + 1, arr, target - arr[ind]);
        result += findCombinations(ind + 1, arr, target + arr[ind]);
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 1};
        int k = findCombinations(0, arr, 3);
        System.out.println(k);
    }
}

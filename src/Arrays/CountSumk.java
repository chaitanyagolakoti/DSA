package Arrays;

public class CountSumk {
    static int helper(int arr[], int ind, int target){
        if(ind >= arr.length){
            return 0;
        }

        int count = 0;
        int sum = 0;

        for (int i = ind; i < arr.length; i++) {
            sum += arr[i];

            if (sum == target) {
                count++;
            }
        }

        return count + helper(arr, ind + 1, target);
    }

    public static int subarraySum(int[] nums, int k) {
        return helper(nums, 0, k);
    }
    public static void main(String[] args) {
        int arr[] = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(arr,k));
    }
}

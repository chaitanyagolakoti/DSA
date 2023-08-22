package Arrays;

public class MaxProSubarray {
    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = maxProduct;
            maxProduct = Math.max(nums[i], Math.max(nums[i] * maxProduct, nums[i] * minProduct));
            minProduct = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * minProduct));
            result = Math.max(result, maxProduct);
        }

        return result;
    }
    public static void main(String[] args) {
        int arr[] = {-2,3,4,-5};
        System.out.println(maxProduct(arr));
    }
}

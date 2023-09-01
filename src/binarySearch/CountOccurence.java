package binarySearch;

public class CountOccurence {
    static int firstlast(int arr[], int target, boolean find) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                ans = mid;
                if (find) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return ans;
    }
    public static int count(int arr[],int target) {
        int ans[] = {-1, -1};
        ans[0] = firstlast(arr, target, true);
        ans[1] = firstlast(arr, target, false);
        // System.out.println(Arrays.toString(ans));
        if (ans[0] == -1 || ans[1] == -1) {
            return 0;
        }
        int res = ans[1] - ans[0] + 1;
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,1,2,2,3,3};
        int target = 3;
        System.out.println(count(arr, 3));
    }
}

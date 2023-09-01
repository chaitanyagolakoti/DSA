package DynamicProgramming;

public class SubsetSumk {
    static boolean subsetExists(int ind, int target, int[] arr) {
        if (ind == arr.length) {
            return target == 0;
        }
        if(target==0){
            return true;
        }
        // Check if there exists a subset including the current element (arr[ind])
        boolean includeCurrent = (target>= arr[ind])?subsetExists(ind + 1, target - arr[ind], arr):false;

        // Check if there exists a subset excluding the current element
        boolean excludeCurrent = subsetExists(ind + 1, target, arr);

        // Return true if either the subset including the current element or the subset excluding the current element exists
        return includeCurrent || excludeCurrent;
    }
    static boolean subsetSumUtil(int ind, int target,int[] arr,int[][] dp){
        if(target==0) {
            return true;
        }
        if(ind == 0) {
            return arr[0] == target;
        }

        if(dp[ind][target]!=-1) {
            return dp[ind][target]==0?false:true;
        }

        boolean notTaken = subsetSumUtil(ind-1,target,arr,dp);

        boolean taken = false;
        if(arr[ind]<=target) {
            taken = subsetSumUtil(ind-1,target-arr[ind],arr,dp);
        }
        dp[ind][target]=notTaken||taken?1:0;
        return notTaken||taken;
    }
    public static void main(String[] args) {
        int arr[] = {4,2,3,1};
        System.out.println(subsetExists(0, 5, arr));
    }
}

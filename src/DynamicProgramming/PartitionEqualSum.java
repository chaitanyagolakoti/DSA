//package DynamicProgramming;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class PartitionEqualSum {
//    static boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp, List<List<Integer>> ans, List<Integer>ds){
//        if(target==0) {
//            ans.add(ds);
//            return true;
//        }
//        if(ind == 0) {
//            return arr[0] == target;
//        }
//
//        if(dp[ind][target]!=-1) {
//            return dp[ind][target]==0?false:true;
//        }
//
//        boolean notTaken = subsetSumUtil(ind-1,target,arr,dp,ans,ds);
//
//        boolean taken = false;
//        if(arr[ind]<=target) {
//            ds.add(arr[ind]);
//            taken = subsetSumUtil(ind-1,target-arr[ind],arr,dp,ans,ds);
//        }
//        dp[ind][target] = notTaken||taken?1:0;
//        return notTaken||taken;
//    }
//
//    public static boolean canPartition(int[] nums) {
//
//        int totSum = 0;
//        for(int i=0;i<nums.length;i++){
//            totSum += nums[i];
//        }
//
//        if(totSum%2 != 0){
//            return false;
//        }
//        int target = totSum/2;
//
//        int dp[][]=new int[nums.length][target+1];
//        for(int row[]: dp)
//            Arrays.fill(row,-1);
//
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer>ds = new ArrayList<>();
//        boolean answ =  subsetSumUtil(nums.length-1,target,nums, dp,ans,ds);
//        System.out.println(ans);
//        return answ;
//    }
//    static void subsetSumUtil(int ind, int target, int[] arr, int[][] dp, List<List<Integer>> ans, List<Integer> ds) {
//        if (target == 0) {
//            ans.add(new ArrayList<>(ds)); // Add a copy of 'ds' to 'ans'
//            return;
//        }
//        if (ind == 0) {
//            if (arr[0] == target) {
//                ds.add(arr[0]);
//                ans.add(new ArrayList<>(ds));
//                ds.remove(ds.size() - 1); // Backtrack
//            }
//            return;
//        }
//
//        if (dp[ind][target] != -1) {
//            if (dp[ind][target] == 1) {
//                ds.add(arr[ind]);
//                subsetSumUtil(ind - 1, target - arr[ind], arr, dp, ans, ds);
//                ds.remove(ds.size() - 1); // Backtrack
//            }
//            subsetSumUtil(ind - 1, target, arr, dp, ans, ds);
//            return;
//        }
//
//        dp[ind][target] = 0;
//        if (arr[ind] <= target) {
//            ds.add(arr[ind]);
//            subsetSumUtil(ind - 1, target - arr[ind], arr, dp, ans, ds);
//            ds.remove(ds.size() - 1); // Backtrack
//        }
//        subsetSumUtil(ind - 1, target, arr, dp, ans, ds);
//
//        dp[ind][target] = 1; // Mark as visited
//    }
//
//
//    public static void main(String[] args) {
//        int arr[] = {1,2,3,6};
//        System.out.println(canPartition(arr));
//    }
//}
